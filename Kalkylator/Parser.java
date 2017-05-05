/**
 * @file Parser.java
 * @brief Module to interpret input as a symbolic expression.
 *
 * Creates a parser to interpret the input stream and create an equivalent
 * symbolic expressions.
 *
 * Both authors have collaboratively written the following code
 * with the aid of an incomplete algorithm, courtesy of Uppsala University:
 * http://www.länk.?
 *
 * @author Caspar Rossland Lindvall
 * @author Haubir Mariwani
 * @since 22th Jan 2016
 */

import java.util.*;
import java.io.*;


/**
 * @brief Parser for reading input stream.
 *
 * Attributes:
 *   StreamTokenizer st: Current stream token.
 *   Reader r:           Buffer for the input stream.
 *   InputStream is:     The input stream
 *   Sexpr ans:          The previous evaluated symbolic expression.
 *
 * @since 22th Jan 2016
 */

public class Parser{
  private StreamTokenizer st = null;
  private Reader r = null;
  private InputStream is = null;
  private Sexpr ans;
  
  
  /**
   * @brief Constructor.
   * Define '-', '/' and end of line as significant characters.
   * For subtraction/negation, division and the end of an expression.
   * @param lastAnswer the previous evaluated sexpr.
   *
   * @since 22th Jan 2016
   */
  
  public Parser(Sexpr lastAnswer){
    is = System.in;
    r = new BufferedReader(new InputStreamReader(is));
    st = new StreamTokenizer(r);
    st.ordinaryChar('-');
    st.ordinaryChar('/');
    st.eolIsSignificant(true);
    ans = lastAnswer;
  }
  
  
  public Parser(Sexpr lastAnswer, String myString){
    //	InputStream stream = new ByteArrayInputStream(stringArray.getBytes(UTF_8));
    //        is = new ByteArrayInputStream( myString.getBytes( charset ) );
    is = new StringBufferInputStream(myString);
    r = new BufferedReader(new InputStreamReader(is));
    st = new StreamTokenizer(r);
    st.ordinaryChar('-');
    st.ordinaryChar('/');
    st.eolIsSignificant(true);
    ans = lastAnswer;
  }
  
  /**
   * @brief Handles statements
   * Checks if the input is a recognized statement and if will it return
   * the corresponding symbolic expression else null.
   *
   * @return The corresponding Sexpr to a valid statement else assignment().
   * @since 22th Jan 2016
   */
  
  public Sexpr statement() throws IOException { //TODO: change name
    st.nextToken();
    if(st.ttype == StreamTokenizer.TT_WORD){
      if("QUIT".equals(st.sval.toUpperCase())){
        return new Quit();
      }
      else if ("VARS".equals(st.sval.toUpperCase())){
        return new Vars();
      }
      else if ("ANSS".equals(st.sval.toUpperCase())){
        return ans;
      }
    }
    else if (st.ttype == StreamTokenizer.TT_EOL) {
      return null;
    }
    st.pushBack();
    
    Sexpr assign = assignment();
    
    return assign;
  }
  
  
  /**
   * @brief Handles symbolic assignments
   * Check if the input is an assignment and if will
   * it return the corresponding symbolic expression else expression().
   *
   * @return Sexpr to an assignment or expression().
   * @since 22th Jan 2016
   */
  
  public Sexpr assignment() throws IOException {
    Sexpr value = expression();
    st.nextToken();
    while (st.ttype == '='){
      value = new Assignment(value, identifier());
      st.nextToken();
    }
    st.pushBack();
    return value;
  }
  
  
  /**
   * @brief Handles addition and subtraction
   * Checks if the input is either an addition  or a subtraction,
   *  if will it create the corresponding symbolic expression.
   *
   * @return Sexpr to an assignment or expression().
   * @since 22th Jan 2016
   */
  
  private Sexpr expression() throws IOException {
    Sexpr sum = term();
    st.nextToken();
    while (st.ttype == '+' || st.ttype == '-') {
      if (st.ttype =='+')
        sum = new Addition(sum, expression());
      else
        sum = new Subtraction(sum, expression());
      st.nextToken();
    }
    st.pushBack();
    return sum;
  }
  
  
  /**
   * @brief Handles multiplication and division
   * Checks if the input is either a multiplication  or
   * a division, if will it create the corresponding symbolic expression
   *
   * @return Sexpr representing either an multiplication or a division else factor().
   * @since 22th Jan 2016
   */
  
  private Sexpr term() throws IOException {
    Sexpr prod = factor();
    st.nextToken();
    while (st.ttype == '*' || st.ttype == '/'){
      if (st.ttype == '*') {
        prod = new Multiplication(prod, term());
      }else{
        prod = new Division(prod, term());
      }
      st.nextToken();
    }
    st.pushBack();
    return prod;
  }
  
  /**
   * @brief Handles parentheses, constants and invalid input
   * Checks if the input is a left parentheses, a unary operation or a constant
   * and will return the corresponding symbolic expression.
   * Otherwise will it interpret it as invalid input.
   * @return Sexpr representing a constant, an expression within parentheses or unary().
   *
   * @since 22th Jan 2016
   */
  
  private Sexpr factor() throws IOException{
    Sexpr result;
    st.nextToken();
    if(st.ttype != '('){
      if(st.ttype == '-' || st.ttype == StreamTokenizer.TT_WORD){
        result = unary();
      }
      else if(st.ttype == StreamTokenizer.TT_NUMBER){
        result = new Constant(st.nval);
      }
      else{
        throw new SyntaxErrorException("Unrecognized input! (Factor level)");
      }
    }else{
      result = assignment();
      if(st.nextToken() != ')'){
        throw new SyntaxErrorException("Expected ')'");
      }
    }
    
    return result;
  }
  
  
  /**
   * @brief Handles all unary operations
   * Checks if the input is either "EXP", "LOG", "SIN" or "COS"
   * and will return the corresponding object.
   * @return Sexpr representing either a unary operation or identifier()'s result
   *
   * @since 22th Jan 2016
   */
  
  
  private Sexpr unary() throws IOException {
    Sexpr single;
    if(st.ttype == '-'){
      single = new Negation(factor());
    }else if("EXP".equals(st.sval.toUpperCase())){
      single = new Exp(factor());
    }else if("LOG".equals(st.sval.toUpperCase())){
      single = new Log(factor());
    }else if("SIN".equals(st.sval.toUpperCase())){
      single = new Sin(factor());
    }else if("COS".equals(st.sval.toUpperCase())){
      single = new Cos(factor());
    }
    else{
      st.pushBack();
      single = identifier();
    }
    return single;
  }
  
  /**
   * @brief Handles variables and syntax errors.
   * Checks if the input is variable or a right parentheses else will it
   * interpret it as a syntax error
   * @return Sexpr representing a variable.
   *
   * @since 22th Jan 2016
   */
  
  private Sexpr identifier() throws IOException{
    st.nextToken();
    try {
      if (st.ttype == StreamTokenizer.TT_WORD){
        return new Variable(st.sval);
      } else {
        throw new SyntaxErrorException("expected ')'");
      }
    } catch(SyntaxErrorException e){
      System.err.println(e);
    }
    return null;
  }
}

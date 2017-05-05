/**
 * @since 22nd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
//package calculator;

import java.util.*;
import java.io.IOException;

/**
 *  Brief description: This functions in this class are called by the eval()-methods
 *  of all the Binary and Unary subclasses
 *
 * <p>
 * Note: This class is not part of the Sexpr hierarchy, it only serves as a helper when evaluating the expressions.
 * </p>
 *
 * @since 22nd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Symbolic {
    
    /**
     *  Method: add(Sexpr term1, Sexpr term2)
     *  Brief description: Handles the addition. If the inputs are of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * @param term1 object of the type Sexpr
     * @param term2 object of the type Sexpr
     * @return A constant containing the result of the addition if both inputs were Constants, else returns a new
     * Addition object containing the inputs for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr add(Sexpr term1, Sexpr term2) {
        if (term1.isConstant() && term2.isConstant())
            return new Constant(term1.getValue() + term2.getValue());
        else
            return new Addition(term1, term2);
    }
    
    /**
     *  Method: subtract(Sexpr minuend, Sexpr subtrahend)
     *  Brief description: Handles the subtraction. If the inputs are of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * @param minuend object of the type Sexpr
     * @param subtrahend object of the type Sexpr
     * @return A constant containing the result of the subtraction if both inputs were Constants, else returns a new
     *  Subtraction object containing the inputs for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr subtract(Sexpr minuend, Sexpr  subtrahend) {
        if (minuend.isConstant() && subtrahend.isConstant())
            return new Constant(minuend.getValue() - subtrahend.getValue());
        else
            return new Subtraction(minuend, subtrahend);
    }
    
    /**
     *  Method: multiply(Sexpr factor1, Sexpr factor2)
     *  Brief description: Handles the multiplication. If the inputs are of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * @param factor1 object of the type Sexpr
     * @param factor2 object of the type Sexpr
     * @return A constant containing the result of the multiplication if both inputs were Constants, else returns a new
     * Multiplication object containing the inputs for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr multiply(Sexpr factor1, Sexpr factor2) {
        if (factor1.isConstant() && factor2.isConstant())
            return new Constant(factor1.getValue() * factor2.getValue());
        else
            return new Multiplication(factor1, factor2);
    }

    /**
     *  Method: divide(Sexpr numerator, Sexpr denominator)
     *  Brief description: Handles the division. If the inputs are of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * <p>
     * Note: There is no exception for division by zero. We are leaving that over to the Java language
     * itself to handle. It handles division by zero by printing "Infinity". We had prepared a class called
     * DivideByZeroException but the project description told us to leave it over to Java.
     * </p>
     * 
     * @param numerator object of the type Sexpr
     * @param denominator object of the type Sexpr
     * @return A constant containing the result of the division if both inputs were Constants, else returns a new
     * Division object containing the inputs for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr divide(Sexpr numerator, Sexpr denominator) {
        if (numerator.isConstant() && denominator.isConstant())
            return new Constant(numerator.getValue() / denominator.getValue());
        else
            return new Division(numerator, denominator);
    }
    
    /**
     *  Method: sin(Sexpr argument)
     *  Brief description: Handles the sinus operation. If the input is of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * @param argument object of the type Sexpr
     * @return A constant containing the result of the sinus operation if the input was a Constant, else returns a new
     * Sin object containing the input for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr sin(Sexpr argument) {
        if (argument.isConstant())
            return new Constant(Math.sin(argument.getValue()));
        else
            return new Sin(argument);
    }
    
    /**
     *  Method: cos(Sexpr argument)
     *  Brief description: Handles the cos operation. If the input is of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     * 
     * @param argument object of the type Sexpr
     * @return A constant containing the result of the cos operation if the input was a Constant, else returns a new
     * Cos object containing the input for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr cos(Sexpr argument){
        if (argument.isConstant())
            return new Constant(Math.cos(argument.getValue()));
        else
            return new Cos(argument);
    }
    
    /**
     *  Method: exp(Sexpr argument)
     *  Brief description: Handles the exp operation. If the input is of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * @param argument object of the type Sexpr
     * @return A constant containing the result of the exp operation if the input was a Constant, else returns a new
     * Exp object containing the input for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr exp(Sexpr argument){
        if (argument.isConstant())
            return new Constant(Math.exp(argument.getValue()));
        else
            return new Exp(argument);
    }
    /**
     *  Method: negate(Sexpr argument)
     *  Brief description: Handles the negation. If the input is of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * @param argument object of the type Sexpr
     * @return A constant containing the result of the negation if the input was a Constant, else returns a new
     * Negation object containing the input for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr negate(Sexpr argument){
        if (argument.isConstant())
            return new Constant(-(argument.getValue()));
        else
            return new Negation(argument);
    }
    
    /**
     *  Method: log(Sexpr argument)
     *  Brief description: Handles the log operation. If the input is of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * <p>
     * Note
     * </p>
     * @param argument of the type Sexpr
     * @return A constant containing the result of the log operation if the input was a Constant, else returns a new
     * Log object containing the input for further evaluation elsewhere in the program.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr log(Sexpr argument){
        if (argument.isConstant())
            return new Constant(Math.log(argument.getValue()));
        else
            return new Log(argument);
    }
    
    /**
     *  Method: assign(Sexpr left, Sexpr right, vars) 
     *  Brief description: Handles the assignment. If the inputs are of the class Constant, it calculates the result
     *  and puts it in a new Constant and returns it.
     *
     * <p>
     * Note
     * </p>
     *
     * @param left of the type Sexpr
     * @param right of the type Sexpr
     * @param vars is the HashMap in which we store our variables and their corresponding values
     * @return The value which the variable was assigned to
     * @throws java.io.IOException at wrong input
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr assign(Sexpr left, Sexpr right, Map<String,Sexpr> vars) throws IOException {
        if (right.isVars()){
            vars.put(right.getName(), left);
            return left;
        }else{
            throw new SyntaxErrorException("Invalid assignment, expected variable");
        }
    }
    
    /**
     *  Method: var(Sexpr identifier, vars)
     *  Brief description: Gets a variables corresponding value from the HashMap, if the HashMap contains
     *  the variable's string identifier as a key.
     *
     * <p>
     * Note
     * </p>
     * @param identifier A string which is the identifier of either an already existing Variable or a
     *  new Variable.
     * @param vars is the HashMap in which we store our variables and their corresponding values.
     *
     *  @return If the variable's string identifier was found in the HashMap, the function returns it's
     *  corresponding value, else it returns a new Variable with the string as it's identifier.
     *
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public static Sexpr var(String identifier, Map<String,Sexpr> vars) {
        if (vars.containsKey(identifier))
            return vars.get(identifier);
        else
            return new Variable(identifier);
    }
}

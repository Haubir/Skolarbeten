/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
//package calculator;

import java.util.*;

/**
 *  class Division
 *  Brief description: The class for Division objects. Stores the numerator and the denominator in
 *  the left and right attributes inherited from the Binary class.
 *
 * <p>
 * Note: There is no exception for division by zero. We are leaving that over to the Java language
 * itself to handle. It handles division by zero by printing "Infinity". We had prepared a class called
 * DivideByZeroException but the project description told us to leave it over to Java.
 * </p>
 *
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Division extends Binary {
    
    /**
     *  Constructor: Division()
     *  Brief description: Constructs a new Binary object of the Division class with two
     *  Sexpr(Symbolic expressions) as it's left and right attributes.
     *
     * @param numerator A Sexpr containing the numerator
     * @param denominator A Sexpr containing the denominator
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Division(Sexpr numerator, Sexpr denominator) {
        super(numerator, denominator);
    }
    
    /**
     *  Method: getName()
     *  Brief description: Returns the string representation of the division operator ("/").
     *
     * @return The string "/"
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String getName() {
        return "/";
    }
    
    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority a
     *  Division object is to have when we print a full Symbolic Expression (Sexpr).
     *
     * @return The integer 2
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public int priority() {
        return 2;
    }
    
    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>divide</i></b>
     *  function in the <b>Symbolic</b> class.
     *
     *  <p>
     *  Note: As previously mentioned we have no exception for division by zero.
     *  </p>
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>divide</i></b> in the <b>Symbolic</b> class.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public Sexpr eval(HashMap<String,Sexpr> vars){ 
        return Symbolic.divide(this.getLeft().eval(vars), this.getRight().eval(vars));
    }
}

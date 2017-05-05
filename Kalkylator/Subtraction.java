/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
//package calculator;

import java.util.*;

/**
 *  class Subtraction
 *  Brief description: The class for Subtraction objects. Stores the two terms in the left and right
 *  attributes inherited from the Binary class.
 *
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Subtraction extends Binary {
    
    /**
     *  Constructor: Subtraction()
     *  Brief description: Constructs a new Binary object of the Subtraction class with two
     *  Sexpr(Symbolic expressions) as it's left and right attributes.
     *
     * @param minuend A Sexpr containing the value that is to be subtracted from.
     * @param subtrahend A Sexpr containing the value that is to be subtracted from the minuend.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Subtraction(Sexpr minuend, Sexpr subtrahend) {
        super(minuend, subtrahend);
    }
    
    /**
     *  Method: getName()
     *  Brief description: Returns the string representation of the subtraction operator ("-").
     *
     *
     * @return The string "-"
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String getName() {
        return "-";
    }
    
    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority a
     *  Subtraction object is to have when we print a full Symbolic Expression (Sexpr).
     *
     *
     * @return The integer 1
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public int priority() {
        return 1;
    }
    
    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>subtract</i></b>
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>subtract</i></b> in the <b>Symbolic</b> class.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public Sexpr eval(HashMap<String,Sexpr> vars){
        return Symbolic.subtract(this.getLeft().eval(vars), this.getRight().eval(vars));
    }
}

/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */

import java.util.*;

/**
 *  class Multiplication
 *  Brief description: The class for Multiplication objects. Stores the two factors in the left and right
 *  attributes inherited from the Binary class.
 *
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Multiplication extends Binary {
    
    /**
     *  Method: Multiplication()
     *  Brief description: Constructs a new Binary object of the Multiplication class with two
     *  Sexpr(Symbolic expressions) as it's left and right attributes.
     *
     * @param factor1 A Sexpr containing a factor
     * @param factor2 A Sexpr containing a factor
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Multiplication(Sexpr factor1, Sexpr factor2) {
        super(factor1, factor2);
    }
    
    /**
     *  Method: getName()
     *  Brief description: Returns the string representation of the multiplication operator ("*").
     *
     *
     * @return The string "*"
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String getName() {
        return "*";
    }
    
    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority a
     *  Multiplication object is to have when we print a full Symbolic Expression (Sexpr).
     *
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
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>multiply</i></b>
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>multiply</i></b> in the <b>Symbolic</b> class.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public Sexpr eval(HashMap<String,Sexpr> vars){
        return Symbolic.multiply(this.getLeft().eval(vars), this.getRight().eval(vars));
    }
}

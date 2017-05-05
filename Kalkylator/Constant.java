/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */

import java.util.*;

/**
 *  class Constant
 *  Brief description: A Constant object will hold a value and will be the final form of a Sexpr
 *  and will end up being evaluated.
 *
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Constant extends Atom {
    /**
     * Attribute: value
     *
     * The value attribute holds the value of the Constant.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    private final double value;
    
    /**
     *  Constructor: Constant()
     *  Brief description: Constructs a new Constant object with a double that will become the value
     *  of the Constant.
     *
     *
     * @param arg The double that will become the value attribute of the Constant.
     * @since 23th Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Constant(Double arg) {
        super();
        this.value = arg;
    }
    
    /**
     *  Method: getName()
     *  Brief description: Returns the string representation of the Constant, which will be
     *  the string representation of it's value.
     *
     * @return The string representation of it's value, in the form of the string representation
     *  of a double.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String getName() {
        return Double.toString(this.value);
    }
    
    /**
     *  Method: getValue()
     *  Brief description: Returns the value of the Constant object
     *
     * @return The value of the object, a double.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public double getValue() {
        return this.value;
    }
    
    /**
     *  Method: isConstant()
     *  Brief description: Checks if a Sexpr object is of the Constant class.
     *
     * @return If the object that called it is a Constant, it returns true, else false.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public boolean isConstant() {
        return true;
    }
    
    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class. Since there is nothing more
     *  to evaluate in this class, the eval()-method returns the object.
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The Constant object.
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public Sexpr eval(HashMap<String, Sexpr> vars) {
        return this;
    }

    @Override
    public boolean equals(Object other) {
	if(this.getClass().equals(other.getClass())) {
	    Constant otherConst = (Constant) other;
	    return (this.getValue() == otherConst.getValue());
	}

	return false;
    }

}

import java.util.*;

/**
 * @file Sin.java
 * 
 * Brief description: Sexpr for sin
 * Sin is a subclass to Unary and represents the symbolic expression of sine
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir Mariwani
 */


public class Sin extends Unary {

    /**
     * Brief description: Constructs a sine
     * Constructs a symbolic expression of sine
     * @param arg is the argument in unary
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Sin(Sexpr arg) {
	super(arg);
    }
    
    /**
     * Used to create a reprensative string for sine 
     * @return String representing the name of a sin object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */

    public String getName() {
	return "sin";
    }

    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>sin</i></b> 
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>sin</i></b> in the <b>Symbolic</b> class.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    
    public Sexpr eval(HashMap<String,Sexpr> vars) {
	return Symbolic.sin(this.getArgument().eval(vars));
    }
}

import java.util.*;

/**
 * @file Exp.java
 * 
 * Brief description: Sexpr for natural exponential.
 * Exp is a subclass to Unary and represents the symbolic expression of natural exponential.
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir Mariwani
 */


public class Exp extends Unary {

    /**
     *  Brief description: Constructs a exponent 
     *  Constructs a symbolic expression of a natural exponent
     * @param arg is the argument in unary.
     * @return
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Exp(Sexpr arg) {
	super(arg);
    }

    /**
     * Used to create a reprensative string for a natural exponent 
     * @return String representing the name of a natural exponent object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public String getName() {
	return "Exp";
    }

    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>exp</i></b> 
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>exp</i></b> in the <b>Symbolic</b> class.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    
    public Sexpr eval(HashMap<String,Sexpr> vars) {
	return Symbolic.exp(this.getArgument().eval(vars));
    }
}

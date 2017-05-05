//package Calculator;
import java.util.*;

/**
 * @file Negation.java
 * 
 * Brief description: Sexpr for negation.
 * Negation is a subclass to Unary and represents the symbolic expression for negation.
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir Mariwani
 */


public class Negation extends Unary {

    public Negation(Sexpr arg) {
	super(arg);
    }

    /**
     * Used to create a reprensative string for cosine 
     * @return String representing the name of a cos object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public String getName() {
	return "-";
    }

    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>negate</i></b> 
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>negate</i></b> in the <b>Symbolic</b> class.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    
    public Sexpr eval(HashMap<String,Sexpr> vars) {
	return Symbolic.negate(this.getArgument().eval(vars));
    }	
}

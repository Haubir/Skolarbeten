//package Calculator;
import java.util.*;

 /**
  * @file Cos.java
  * 
  * Brief description: Sexpr for cos
  * Cos is a subclass to Unary and represents the symbolic expression of cosine
  * 
  * @since 22th Jan 2016
  * @author Caspar Rossland Lindvall and Haubir Mariwani
  */


public class Cos extends Unary {

    /**
     * Brief description: Constructs a cosine 
     * Constructs a symbolic expression of a cosine
     * @param arg is the argument in unary
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Cos(Sexpr arg) {
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
	return "Cos";
    }

    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>cos</i></b> 
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>cos</i></b> in the <b>Symbolic</b> class.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    
    public Sexpr eval(HashMap<String,Sexpr> vars) {
	return Symbolic.cos(this.getArgument().eval(vars));
    }

}

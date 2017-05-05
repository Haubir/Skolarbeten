import java.util.*;

/**
 * @file Log.java
 * 
 * Brief description: Sexpr for log
 * Log is a subclass to Unary and represents the symbolic expression of natural logarithm
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir Mariwani
 */


public class Log extends Unary {
    
    /**
     * Brief description: Constructs a logarithm 
     * Constructs a symbolic expression of a natural logarithm
     * @param toLog is the argument in unary
     * @return
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Log(Sexpr toLog) {
	super(toLog);
    }

        
    /**
     * Used to create a reprensative string for a natural logarithm 
     * @return String representing the name of a Log object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public String getName() {
	return "Log";
    }

    
    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>log</i></b> 
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>log</i></b> in the <b>Symbolic</b> class.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    
    public Sexpr eval(HashMap<String,Sexpr> vars) {
	return Symbolic.log(this.getArgument().eval(vars));
    }
}

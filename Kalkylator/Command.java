import java.util.*;
/**
 * Command is an abstract class that handles all command expressions.
 * A command operation has no arguments. The different command operations are
 * vars and quit.
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir MariwaniAktiv
 */

public abstract class Command extends Sexpr{
    public Command() {

    }
    
    /**
     * Creates a string representing the command operation.
     * 
     * @return String representing the unary operation,
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public String toString() {
	if (this == null)
	    return "";
	else
	    return getName();
    }

    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority all 
     *  all objects have when we print a full Symbolic Expression (Sexpr).
     *
     *
     * @return The integer 4
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public int priority() {
	return 4;
    }
}

import java.util.*;

/**
 * @file Quit.java
 * 
 * Brief description: Sexpr for quit
 * Quit is a subclass to command and represents the symbolic expression for
 * exiting the simulation.
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir Mariwani
 */

public class Quit extends Command {

    /**
     * Attribute: SUCCESS
     * 
     * A convention for  expressing a successfull exit.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    protected int SUCCESS = 0;

    /**
     * Attribute: FAILURE
     * 
     * Means for expressing an unsuccessfull exit. 
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */

    protected int FAILURE = -1;

    /**
     * Used to create a reprensative string for quit 
     * @return String representing the name of a quit object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public String getName() {
	return "quit";
    }

    /**
     * Used to determine if the current object is a quit. 
     * @return True.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public boolean isQuit() {
	return true;
    }


    /**
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority all 
     *  Unary objects have when we print a full Symbolic Expression (Sexpr).
     *
     * @return The integer 2
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public int priority() {
	return -1;
    }

    
    /**
     *  Brief description: Exit the system
     *  Exit the system successfully.
     * <p>
     * Note: Both the argument and return is trivial but necessary
     * as eval is inherited from sexpr. 
     * </p>
     *
     * @return Null
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Sexpr eval(HashMap<String, Sexpr> vars) {
	System.exit(SUCCESS);
	return null;
    }
}

//package Calculator;
import java.util.*;

/**
 * @file Vars.java
 * 
 * Brief description: Sexpr for Vars
 * Vars is a subclass to command and represents the symbolic expression for
 * symbolic variables.
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir Mariwani
 */

public class Vars extends Command {

    /**
     * Used to create a reprensative string for var 
     * @return String "vars".
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */

    public String getName() {
	return "vars";
    }
    
    /**
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority all 
     *  varrs objects have when we print a full Symbolic Expression (Sexpr).
     *
     *
     * @return The integer -1
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public int priority() {
	return -1;
    }

    /**
     *  Brief description: Print out the stored variables
     *  Prints out the map vars content using the hashmaps toString.
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return Vars, trivial.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */

    public Sexpr eval(HashMap<String, Sexpr> vars) {
	System.out.println(vars);
	return this;
    }
	
}

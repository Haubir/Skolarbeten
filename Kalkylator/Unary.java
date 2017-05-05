//package Calculator;

/**
 * Unary is an abstract class that handles all unary mathematical expressions.
 * A unary operation has a single argument, a sexpr. The different unary operations are
 * cosine, natural exponential, natural logarithm, negation and sine.
 * 
 * @since 22th Jan 2016
 * @author Caspar Rossland Lindvall and Haubir MariwaniAktiv
 */

public abstract class Unary extends Sexpr{

    /**
     * Attribute: argument
     * 
     * The arguemnt of all unary objects. It holds a Sexpr. 
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    private Sexpr argument;
    
    /**
     * Constructs a unary operation
     *
     * @param arg the argument for the unary object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Unary(Sexpr arg) {
	super();
	this.argument = arg;
    }
    
    /**
     * Brief description: Creates a string representing the unary operation.
     * Depending on which unary operation will it create a representative 
     * string with it's argument within parentheses.
     * 
     * @return String representing the unary operation,
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */

    public String toString() {
	return getName() + "(" + argument.toString() + ")";
    }
    /**
     * A function to get the unary obejct's argument
     *
     * @return Sexpr from the unary object.
     * 
     * @since 22th Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */
    
    public Sexpr getArgument() {
        return this.argument;
    }

    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority all 
     *  Unary objects have when we print a full Symbolic Expression (Sexpr).
     *
     *
     * @return The integer 2
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall and Haubir Mariwani
     */

    public int priority() {
	return 2;
    }
}

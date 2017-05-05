/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */

/**
 * class Binary
 *  Brief description: This class represents the following mathematical operations and classes:
 * <p>
 * <ul>
 *      <li> Assignment</li>
 *      <li> Addition</li>
 *      <li> Subtraction</li>
 *      <li> Multiplication</li>
 *      <li> Division</li>
 * </ul>
 * </p>
 *
 * @since 22nd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public abstract class Binary extends Sexpr{
/**
 * Attribute: left
 * 
 * The left attribute of all object of the Binary class. It holds a Sexpr. 
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
    private final Sexpr left;

/**
 * Attribute: right
 * 
 * The right attribute of all object of the Binary class. It holds a Sexpr. 
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
    private final Sexpr right;
    
    /**
     *  Constructor: Binary()
     *  Brief description: Constructs a new Binary object with two Sexpr(Symbolic expressions)
     *  as it's left and right attributes.
     *
     *
     * @param left is an object of the class Sexpr
     * @param right is an object of the class Sexpr
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Binary(Sexpr left, Sexpr right) {
        super();
        this.left = left;
        this.right = right;
    }
    
    /**
     *  Method: getLeft()
     *  Brief description: Gets the Binary objects left attribute
     *
     *
     * @return the objects left attribute
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Sexpr getLeft() {
        return this.left;
    }
    
    /**
     *  Method: getRight()
     *  Brief description: Gets the Binary objects right attribute
     *
     *
     * @return the objects right attribute
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Sexpr getRight() {
        return this.right;
    }
    
    /**
     *  Method: toString()
     *  Brief description: Returns the string representation of the object, which depends on
     *  the priorities of  the object and it's left and right attributes.
     *
     *
     * @return a string representation of the object
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String toString() {
        if (left.priority() < this.priority() && right.priority() < this.priority())
            return "(" + this.left + ")" + getName() + "(" + this.right + ")";
        
        else if (right.priority() < this.priority())
            return this.left + getName() + "(" + this.right + ")";
        
        else if (left.priority() < this.priority())
            return "(" + this.left + ")" + getName() + this.right;
        
        else
            return this.left + getName() + this.right;
    }


    public boolean equals(Object other){
	if(this.getClass().equals(other.getClass())){
	    Binary otherBin = (Binary) other;
	    return (this.getLeft().equals(otherBin.getLeft()) &&
		    this.getRight().equals(otherBin.getRight()));
	}
	return false;
    }
}

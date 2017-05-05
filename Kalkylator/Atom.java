/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */

/**
 * class Atom
 *  Brief description: This class represents the following classes:
 * <p>
 * <ul>
 *      <li> Constant</li>
 *      <li> Variable</li>
 * </ul>
 * </p>
 *
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public abstract class Atom extends Sexpr{
    
    /**
     *  Constructor: Atom()
     *  Brief description: Constructs a new Atom object.
     *
     *
     * @since 23th Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Atom(){
        super();
    }
    
    /**
     *  Method: toString()
     *  Brief description: Returns the string representation of the object depending on the class
     *  of the object.
     *
     * @return a string representation of the object class (the result from the getName() method of
     *  either Constant or Variable)
     * @since 23th Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String toString() {
        return getName();
    }
    
    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority an
     *  Atom object is to have when we print a full Symbolic Expression (Sexpr).
     *
     * @return The integer 3
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public int priority() {
        return 3;
    }
}

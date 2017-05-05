/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/**
 *  class Assignment
 *  Brief description: The class for Assignment objects. Stores the value and the variable that is to be
 *  assigned in the left and right attributes inherited from the Binary class.
 *
 *
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Assignment extends Binary {
    
    /**
     *  Constructor: Assignment()
     *  Brief description: Constructs a new Binary object of the Assignment class with two 
     *  Sexpr(Symbolic expressions) as it's left and right attributes.
     *
     *
     * @param left A Sexpr object containing the value that will be assigned to the Variable object
     *  that is the right param.
     * @param right A Sexpr object of the class Variable that will be assigned to the value in the
     *  left param.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Assignment(Sexpr left, Sexpr right) {
        super(left, right);
    }
    
    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority an
     *  Assignment object is to have when we print a full Symbolic Expression (Sexpr).
     *
     *
     * @return The integer 0
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public int priority() {
        return 0;
    }
    
    /**
     *  Method: getName()
     *  Brief description: Returns the string representation of the assignment operator ("=").
     *
     *
     * @return The string "="
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String getName() {
        return " = ";
    }
    
    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>assign</i></b>
     *  function in the <b>Symbolic</b> class. Needs to try and catch the SyntaxErrorException that 
     *  <b><i>assign</i></b> could potentially throw.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>assignment</i></b> in the <b>Symbolic</b> class.
     * @since 23rd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public Sexpr eval(HashMap<String, Sexpr> vars){
        try {
            return Symbolic.assign(this.getLeft().eval(vars), this.getRight(), vars);
        } catch (IOException ex) {
            Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}    

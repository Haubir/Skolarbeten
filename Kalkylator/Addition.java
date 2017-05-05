/**
 * @since 22nd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
//package calculator;

import java.util.*;

/**
 *  class Addition
 *  Brief description: The class for Addition objects. Stores the two terms in the left and right 
 *  attributes inherited from the Binary class.
 *
 *
 * @since 22nd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class Addition extends Binary{

    /**
     *  Constructor: Addition()
     *  Brief description: Constructs a new Binary object of the Addition class with two Sexpr(Symbolic expressions)
     *  as it's left and right attributes.
     *
     *
     * @param term1 The first term which becomes the left attribute
     * @param term2 The second term which becomes the right attribute
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    public Addition(Sexpr term1, Sexpr term2) {
        super(term1, term2);      
    }
    
    /**
     *  Method: getName()
     *  Brief description: Returns the string representation of the addition operator ("+").
     *
     *
     * @return The string "+" 
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public String getName(){
        return "+";
    }
    
    /**
     *  Method: priority()
     *  Brief description: Inherited from Sexpr, it returns the integer that decides what priority an 
     *  Addition object is to have when we print a full Symbolic Expression (Sexpr).
     *
     *
     * @return The integer 1
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public int priority() {
        return 1;
    }
    
    /**
     *  Method: eval(vars)
     *  Brief description: Handles the evaluation of all objects of this class by calling the <b><i>add</i></b> 
     *  function in the <b>Symbolic</b> class.
     *
     *
     * @param vars The HashMap that contains our stored variables and their corresponding values.
     * @return The result of the function <b><i>add</i></b> in the <b>Symbolic</b> class.
     * @since 22nd Jan 2016
     * @author Caspar Rossland Lindvall & Haubir Mariwani
     */
    @Override
    public Sexpr eval(HashMap<String, Sexpr> vars){ 
        return Symbolic.add(this.getLeft().eval(vars), this.getRight().eval(vars));
    }
}

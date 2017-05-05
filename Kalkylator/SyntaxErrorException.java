/**
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
//package calculator;

import java.io.*;

/**
 *  class SyntaxErrorException
 *
 *  Brief description: Handles all wrong inputs in the program.
 * @since 23rd Jan 2016
 * @author Caspar Rossland Lindvall & Haubir Mariwani
 */
public class SyntaxErrorException extends RuntimeException implements Serializable{
    /**
     * Attribute: serialVersionUID
     * 
     * Brief description: This attribute is needed by the Java compiler so that it doesn't complain about not 
     * finding the serial version UID of the class. We also tried implementing the @SuppressWarnings("serial") 
     * deprecation but that would only be avoiding the problem. Although the deprecation wouldn't harm the 
     * program, it seemed like better coding standards to declare the serial version UID for the compiler.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor: SyntaxErrorExcpetion()
     * 
     * Brief description: Constructs an object of this class without a message.
     */
    public SyntaxErrorException(){
        super();
    }

    /**
     * Constructor: SyntaxErrorExcpetion()
     * 
     * Brief description: Constructs an object of this class with a message.
     * 
     * @param msg Contains the message that the program will print to the user.
     */
    public SyntaxErrorException(String msg){
        super(msg);
    }
}

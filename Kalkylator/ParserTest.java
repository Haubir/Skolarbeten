//package calculator;
import java.io.*;
/*
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/
/**
 * 
 * @author haubir
 * @author Caspar Rossland Lindvall
 */

public class ParserTest{ 

    public static void main(String args[]) throws IOException {
	parserTest();
	Sexpr expected = new Addition(new Constant(5.0), new Constant(5.0));
	String inputAddition = "5 + 5";
	Parser p = new Parser(null, inputAddition);
	Sexpr e = p.statement();
	assert(expected.equals(e));
	System.out.println("Done!");
    }

    /**
     * Test for correct parsing
     * @throws java.lang.Exception
     */
    public static void parserTest() throws IOException {
	String input[] = {"5 + 5", "2 + 6 / 3 = a", "cos(0) + sin 0 - log(2 + 1)", "(((5 + 2) + 1) -1)", "5*(x+2)", "cos y + 5*a - 3*(u+1) = z"};
	
        String excpectedOutput[] = {"5.0+5.0","2.0+6.0/3.0 = a", "Cos(0.0)+sin(0.0)-Log(2.0+1.0)", "5.0+2.0+1.0-1.0", "5.0*(x+2.0)", "Cos(y)+5.0*a-3.0*(u+1.0) = z"};

	Sexpr statement = null; 
	for(int i = 0; i < input.length; i++){
	    Parser pars = new Parser(statement, input[i]);
	    statement = pars.statement();
	    System.out.println("checking if " + statement + " is equal to " + excpectedOutput[i]);
	    assert(excpectedOutput[i].equals(statement.toString()));
	}
    }
    // /**
    //  * Test of statement method, of class Parser.
    //  * @throws java.lang.Exception
    //  */
    // @Test
    // public void testStatement() throws Exception {
    //     System.out.println("statement");
    //     Parser instance = null;
    //     Sexpr expResult = null;
    //     Sexpr result = instance.statement();
    //     assertEquals(result, expResult);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of assignment method, of class Parser.
    //  * @throws java.lang.Exception
    //  */
    // @Test
    // public void testAssignment() throws Exception {
    //     System.out.println("assignment");
    //     Parser instance = null;
    //     Sexpr expResult = null;
    //     Sexpr result = instance.assignment();
    //     assertEquals(result, expResult);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }
    


    // //Remove?
    // @BeforeClass
    // public static void setUpClass() throws Exception {
    // }

    // @AfterClass
    // public static void tearDownClass() throws Exception {
    // }

    // @BeforeMethod
    // public void setUpMethod() throws Exception {
    // }

    // @AfterMethod
    // public void tearDownMethod() throws Exception {
    // }


}

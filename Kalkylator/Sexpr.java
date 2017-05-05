import java.io.StreamTokenizer;
import java.io.IOException;
import java.util.*;


public abstract class Sexpr{
    public Sexpr() {

    }

    public abstract String getName();

    public abstract Sexpr eval(HashMap<String, Sexpr> vars);

    public boolean isConstant() {
	return false;
    }

    public boolean isVars() {
	return false;
    }

    public boolean isQuit() {
	return false;
    }
    
    public abstract int priority(); // TODO
    /**
     * Priorities:
     *
     * 0: Atoms, Assignment
     * 1: Addition, Subtraction
     * 2: Unary, Multiplication, Division
     * 3: ?
     * 4: Quit, Vars
     */
    public double getValue(){
	return 0;
    }

    public static void main(String [] args) {
	System.out.println("Inga errors!");
    }
}

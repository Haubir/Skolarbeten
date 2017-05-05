import java.util.*;

public class Variable extends Atom {
    private String ident;

    public Variable(String identifier) {
	super();
	this.ident = identifier;
    }
    
    public String getName() {
	return this.ident;
    }

    public boolean isVars() {
	return true;
    }
    
    public Sexpr eval(HashMap<String,Sexpr> vars) {
        Sexpr e = Symbolic.var(this.ident, vars);
	if (vars.containsValue(e) && !e.isVars()) {
	    return e.eval(vars);
	}
	else
	    return e;
    }
}

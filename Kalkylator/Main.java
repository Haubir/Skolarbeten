//package Calculator;
import java.util.*;
import java.io.*;
public class Main {
  
  public static void main(String [] args) {
    
    HashMap<String,Sexpr> vars = new HashMap<String,Sexpr>();
    Sexpr e = null;
    while (true){
      try {
        Parser p = new Parser(e);
        System.out.print("? ");
        e = p.statement();
        
        if (e != null) {
          System.out.println("Inläst uttryck: " + e);  // För kontroll
          Sexpr result = e.eval(vars);
          System.out.println(result);
          
          Symbolic.assign(result, new Variable("ans"), vars);
        }
      } catch (IOException fel) {
        System.err.println(fel);
        
      }
      
    }
  }
}

package Week2.VisitorPattern;

// A Concrete Week2.VisitorPattern.Visitor
public class PrettyPrint implements  Visitor<Void>{

    private StringBuffer sb = new StringBuffer();

    public static String pp(Expression e){
        // create a new pretty printer instance
        PrettyPrint pp = new PrettyPrint();
        // and accept the expression with it
        e.accept(pp);
        // when finished, return what string we built up
        return pp.sb.toString();
    }

    public Void visit(Number c){
        // a constant is just a number
        sb.append(c.value);
        return null;
    }

    public Void visit(Variable v){
        // a variable is just a letter/name
        sb.append(v.name);
        return null;
    }

    public Void visit(Add a){
        // an addition is an expression
        // then a plus sign then another
        // expression all wrapped in parentheses
        sb.append("(");
        a.left.accept(this); //pass in this instance of
        sb.append(" + "); // the pretty printer so sub expressions
        a.right.accept(this); // have access to the String Buffer
        sb.append(")");
        return null;
    }
}

package Week2.VisitorPattern;

import java.util.Map;

public class Evaluator implements Visitor<Integer> {
    private Map<String, Integer> env;

    private Evaluator(Map<String, Integer> env){
        this.env = env;
    }

    public static int eval(Expression e, Map<String, Integer> env){
        // create a new Week2.VisitorPattern.Evaluator visitor with an
        // environment that holds information about variables
        Evaluator eval = new Evaluator(env);
        // begin evaluation by visiting the expression
        // with the expression with the evaluation visitor
        return e.accept(eval);
    }

    public Integer visit(Number c){
        // to evaluate a number, just return its value
        return c.value;
    }

    public Integer visit(Variable v){
        // to evaluate a variable, look up
        // the variable name in the environment
        // and get its value
        return env.get(v.name);
    }

    public Integer visit(Add add){
        // to evaluate an addition
        // evaluate the left side
        Integer left = add.left.accept(this);
        // evaluate the right side
        Integer right = add.right.accept(this);
        // and add them together
        return left + right;
    }
}

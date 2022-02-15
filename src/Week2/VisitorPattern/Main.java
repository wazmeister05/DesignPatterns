package Week2.VisitorPattern;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // an addition expression in our small language
        Expression test = new Add(
                new Add(new Number(5), new Number(6)),
                new Add(
                        new Variable("x"),
                        new Add(new Number(3), new Number(10)))
                );
        System.out.println(PrettyPrint.pp(test));

        // Create an empty environment
        Map<String, Integer> env = new HashMap<>();
        // give the variable x the value 18 (in the environment)
        env.put("x", 18);
        // evaluate the test expression in the environment
        int result = Evaluator.eval(test, env);
        // print out the result
        System.out.println(result);
    }
}

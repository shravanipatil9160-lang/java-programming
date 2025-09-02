import java.util.*;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Input expression cannot be null or empty.");
        }

        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    
    public static void main(String[] args) {
        String[] testExpressions = {
            "2 1 + 3 *",              
            "5 6 +",                 
            "-5 6 -",              
            "15 7 1 1 + - / 3 * 2 1 1 + + -", 
            "5",                    
            "3 4 2 * 1 5 - 2 3 ^ ^ / +"
        };

        for (String expr : testExpressions) {
            try {
                int result = evaluatePostfix(expr);
                System.out.println("Input: \"" + expr + "\" => Output: " + result);
            } catch (Exception e) {
                System.out.println("Input: \"" + expr + "\" => Error: " + e.getMessage());
            }
        }
    }
}

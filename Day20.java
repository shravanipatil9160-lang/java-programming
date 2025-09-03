import java.util.Stack;

public class RecursiveStackSort {

    
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            
            int top = stack.pop();

            
            sortStack(stack);

        
            insertInSortedOrder(stack, top);
        }
    }

    
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
    
        if (stack.isEmpty() || element <= stack.peek()) {
            stack.push(element);
            return;
        }

        
        int top = stack.pop();
        insertInSortedOrder(stack, element);

    
        stack.push(top);
    }

    
    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.print(val + " ");
            temp.push(val);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        System.out.println();
    }

    
    public static void main(String[] args) {
        test(new int[]{3, 1, 4, 2});
        test(new int[]{7, 1, 5});
        test(new int[]{5});
        test(new int[]{-3, 14, 8, 2});
        test(new int[]{});
        test(new int[]{3, 3, 3});
    }

    
    private static void test(int[] input) {
        Stack<Integer> stack = new Stack<>();
    
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }

        System.out.println("Input Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
        System.out.println("---------------");
    }
}

import java.util.Stack;

public class Solution {

    public static String preToPost(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            // Operator
            else {

                String operand1 = stack.pop();
                String operand2 = stack.pop();

                String postfix = operand1 + operand2 + ch;

                stack.push(postfix);
            }
        }

        return stack.pop();
    }
}
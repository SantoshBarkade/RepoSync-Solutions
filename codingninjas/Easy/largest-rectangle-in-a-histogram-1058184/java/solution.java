import java.util.*;

public class Solution {

    public static int largestRectangle(ArrayList<Integer> heights) {

        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = heights.size();

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights.get(i);

            while (!stack.isEmpty() &&
                   currHeight < heights.get(stack.peek())) {

                int height = heights.get(stack.pop());

                int right = i;

                int left = stack.isEmpty() ? -1 : stack.peek();

                long width = right - left - 1;

                maxArea = Math.max(maxArea, width * height);
            }

            stack.push(i);
        }

        return (int) maxArea;
    }
}
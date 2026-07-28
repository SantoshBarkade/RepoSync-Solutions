import java.util.*;

public class Solution {

    public static String removeKDigits(String num, int k) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peekLast() > ch) {

                stack.pollLast();
                k--;
            }

            stack.offerLast(ch);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // Build result
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pollFirst());
        }

        // Remove leading zeros
        int index = 0;

        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }

        String result = ans.substring(index);

        if (result.length() == 0)
            return "0";

        return result;
    }
}
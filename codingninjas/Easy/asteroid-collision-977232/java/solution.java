import java.util.*;

public class Solution {

    public static List<Integer> collidingAsteroids(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Handle collisions
            while (!stack.isEmpty() &&
                    stack.peek() > 0 &&
                    asteroid <= 0) {

                // Massless asteroid always gets destroyed
                if (asteroid == 0) {
                    destroyed = true;
                    break;
                }

                // Current asteroid is bigger
                if (stack.peek() < -asteroid) {
                    stack.pop();
                }

                // Both are equal
                else if (stack.peek() == -asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                }

                // Stack asteroid is bigger
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        return new ArrayList<>(stack);
    }
}
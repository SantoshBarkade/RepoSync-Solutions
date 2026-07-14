import java.util.*;

public class Solution {

    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long mod = 1000000007L;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                left[i] = i + 1;
            else
                left[i] = i - st.peek();

            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                right[i] = n - i;
            else
                right[i] = st.peek() - i;

            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) ans;
    }
}
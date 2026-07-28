# LCA of three Nodes

- **Platform:** codingninjas
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://www.naukri.com/code360/problems/remove-k-digits_1461221?leftPanelTabValue=SUBMISSION)

## Solution Notes

## 1. **Brute Force Approach**

A brute force approach to this problem would involve generating all possible subsequences of the length `(n - k)` from the given string `num`, where `n` is thethoughtful length of the original number string. For each subsequence, the value would be converted to a number and compared to find the maximum or minimum (depending on the goal). Since the goal here is to remove `k` digits to make the smallest possible number, one would evaluate all combinations of length `n-k` and select the one with the smallest numerical value. However, the number of such combinations is $\binom{n}{k}$, which grows exponentially with $n$, making this approach computationally infeasible for large inputs.

## 2. **Optimal Approach**

The provided solution uses a **Monotonic Stack** strategy to ensure that the digits in the resulting number are in non-decreasing order as much as possible. The intuition is that a smaller digit at a higher place value (more to the left) results in a smaller overall number. 

### Detailed Steps:

1. **Monotonic Stack Construction**: 
   - We iterate through each character `ch` in the input string `num`.
   - While the stack is not empty, we still have removals remaining (`k > 0`), and the top of the stack is strictly greater than the current digit (`stack.peekLast() > ch`), it means that removing the digit at the top of the stack and replacing it with the current smaller digit will result in a smaller number.
   - In this case, we `pollLast()` (pop from the stack) and decrement `k`.
   - We then push the current digit `ch` onto the stack.

2. **Handling Remaining Removals**: 
   - After iterating through all digits, if `k` is still greater than 0, it means the digits in the stack are in non-decreasing order (e.g., in a number like "12345", no digits were removed because each subsequent digit was larger). 
   - To maintain the smallest number, we remove the remaining `k` digits from the end (the largest digits) of the stack using `stack.pollLast()`.

3. **Result Construction and Formatting**:
   - We build a string `ans` by polling elements from the front of the stack (`pollFirst()`).
   - **Leading Zeros**: A common issue in numerical strings is leading zeros (e.g., "0200" instead of "200"). We iterate through the string starting from index 0 and find the first non-zero digit.
   - **Edge Case (Empty Result)**: If the removal of digits or the stripping of leading zeros results in an empty string, the function returns "0" as per the problem requirements.

## 3. **Complexity Analysis**

### Time Complexity: $O(N)$
- We iterate through the input string of length $N$ exactly once. 
- Although there is a nested `while` loop, each digit is pushed onto the stack once and popped from the stack at most once. Therefore, the total number of operations is proportional to $2N$, which simplifies to $O(N)$.
- The final string construction and leading zero removal also take $O(N)$ time.

### Space Complexity: $O(N)$
- We use a Deque (acting as a stack) to store the digits of the number. In the worst case (where no digits are removed or the string is non-decreasing), the stack will store $N$ characters. 
- The `StringBuilder` used for the result also takes $O(N)$ space.

## 4. **Dry Run**

**Input**: `num = "1432219"`, `k = 3`

| Step | Digit (`ch`) | Stack (after operation) | `k` (remaining) | Action |
| :--- | :--- | :--- | :--- | :--- |
| 1 | '1' | `['1']` | 3 | Push '1' |
| 2 | '4' | `['1', '4']` | 3 | Push '4' (4 > 1) |
| 3 | '3' | `['1', '3']` | 2 | Pop '4' (4 > 3), Push '3' |
| 4 | '2' | `['1', '2']` | 1 | Pop '3' (3 > 2), Push '2' |
| 5 | '2' | `['1', '2', '2']` | 1 | Push '2' (2 == 2) |
| 6 | '1' | `['1', '2', '1']` | 0 | Pop '2' (2 > 1), Push '1' |
| 7 | '1' | `['1', '2', '1', '9']` | 0 | Push '9' |

**Post-Loop Processing**:
- `k` is now 0. No more `pollLast()` from the main loop.
- `ans` string built from stack: `"1219"`.
- Leading zero check: No leading zeros found.
- `result` = `"1219"`.

**Final Output**: `"1219"`

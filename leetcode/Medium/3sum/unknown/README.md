# 15. 3Sum

- **Platform:** leetcode
- **Difficulty:** Medium
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/3sum/submissions/2066487037/)

## Solution Notes


## AI Solution Notes

*   Problem: 15. 3Sum.
    *   Goal: Write detailed markdown notes for the provided Java code.
    *   Sections required:
        1.  **Brute Force Approach**
        2.  **Optimal Approach**
        3.  **Complexity Analysis**
        4.  **Dry Run**
    *   Constraints: Exactly these sections, nothing else. No conversational filler.

    *   The code sorts the array first.
    *   It iterates through the array with an index `i`.
    *   It skips duplicates for `i` using `if(i > 0 && nums[i] == nums[i - 1]) continue;`.
    *   It uses two pointers (`left` and `right`) to find pairs that, when added to `nums[i]`, equal zero.
    *   It handles duplicates for `left` and `right` after finding a valid triplet.

    *   **1. Brute Force Approach**: Use three nested loops to check every possible combination of three numbers. If the sum is zero, add it to the result set (using a Set to avoid duplicates).

    *   **2. Optimal Approach**:
        *   **Step 1: Sorting**: Sort the input array. This allows us to use the two-pointer technique and easily skip duplicate values.
        *   **Step 2: Iteration**: Iterate through the array using a loop index `i`. This `nums[i]` acts as the fixed first element of the triplet.
        *   **Step 3: Duplicate Handling (Fixed Element)**: If the current element is the same as the previous one (`nums[i] == nums[i-1]`), skip it to avoid duplicate triplets.
        *   **Step 4: Two-Pointer Search**: For each `i`, initialize two pointers: `left` at `i + 1` and `right` at the end of the array.
        *   **Step 5: Sum Comparison**:
            *   If `sum == 0`: We found a triplet. Add it to the result. Increment `left` and decrement `right`. To avoid duplicates, skip all identical elements for both `left` and `right`.
            *   If `sum < 0`: The sum is too small. Since the array is sorted, increment `left` to increase the sum.
            *   If `sum > 0`: The sum is too large. Decrement `right` to decrease the sum.

    *   **3. Complexity Analysis**:
        *   **Time Complexity**: $O(n^2)$. Sorting takes $O(n \log n)$. The outer loop runs $n$ times, and the inner two-pointer search also runs up to $n$ times, leading to $O(n^2)$.
        *   **Space Complexity**: $O(1)$ or $O(n)$ depending on the sorting implementation's space requirements and whether the output list is counted. Usually, $O(\log n)$ to $O(n)$ for the sorting stack.

    *   **4. Dry Run**:
        *   Example: `nums = [-1, 0, 1, 2, -1, -4]`
        *   **Sorted**: `[-4, -1, -1, 0, 1, 2]`
        *   **i = 0** (`nums[i] = -4`):
            *   `left = 1` (`-1`), `right = 5` (`2`). Sum = -4 + (-1) + 2 = -3. `sum < 0`, so `left++`.
            *   `left = 2` (`-1`), `right = 5` (`2`). Sum = -4 + (-1) + 2 = -3. `sum < 0`, so `left++`.
            *   `left = 3` (`0`), `right = 5` (`2`). Sum = -4 + 0 + 2 = -2. `sum < 0`, so `left++`.
            *   `left = 4` (`1`), `right = 5` (`2`). Sum = -4 + 1 + 2 = -1. `sum < 0`, so `left++`.
            *   `left == right`, exit inner loop.
        *   **i = 1** (`nums[i] = -1`):
            *   `left = 2` (`-1`), `right = 5` (`2`). Sum = -1 + (-1) + 2 = 0. **Match!** Add `[-1, -1, 2]`.
            *   `left++` (to 3), `right--` (to 4).
            *   Check duplicates: `nums[3]=0` (not same as `nums[2]`), `nums[4]=1` (not same as `nums[5]`).
            *   `left = 3` (`0`), `right = 4` (`1`). Sum = -1 + 0 + 1 = 0. **Match!** Add `[-1, 0, 1]`.
            *   `left++` (to 4), `right--` (to 3). `left < right` is false, exit inner loop.
        *   **i = 2** (`nums[i] = -1`):
            *   `nums[2] == nums[1]`, so `continue` (skipping duplicates).
        *   **i = 3** (`nums[i] = 0`):
            *   `left = 4` (`1`), `right = 5` (`2`). Sum = 0 + 1 + 2 = 3. `sum > 0`, so `right--`.
            *   `left == right`, exit loop.
        *   Final Result: `[[-1, -1, 2], [-1, 0, 1]]`.

    *   Check against constraints: "exactly these sections with nothing else".
    *   Ensure no intro or outro text.

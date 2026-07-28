# 493. Reverse Pairs

- **Platform:** leetcode
- **Difficulty:** Hard
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/reverse-pairs/submissions/2072699994/)

## Solution Notes


## AI Solution Notes

## 1. **Brute Force Approach**

A simple brute force approach involves using two nested loops to iterate through every possible pair $(i, j)$ in the array where $0 \le i < j < \text{nums.length}$. For each pair, we check if the condition $\text{nums}[i] > 2 \times \text{nums}[j]$ is satisfied. If it is, we increment a global counter. This approach has aO(N^2) time complexity, which is inefficient for large input arrays.

## 2. **Optimal Approach**

This solution utilizes the **Merge Sort** paradigm to achieve an optimized time complexity. The problem of counting reverse pairs can be be framed as a counting problem during the sorting process. The core idea is to divide the ability to count pairs while the array is being sorted into three distinct stages within the the recursive structure of Merge Sort.

### **Algorithm Logic**

1.  **Divide and Conquer**: The `mergeSort` function recursively splits the array into halves until the single-element sub-arrays are reached. 
2.  **Counting the Pairs (The `countPairs` function)**: After the left and right sub-arrays are recursively sorted, but *before* the actual merging step, we calculate the number of reverse pairs that cross the boundary between the left half and the right half. 
    *   Because both the left and right sub-arrays are already sorted individually, we can use a **two-pointer approach** within the `countPairs` function. 
    *   For each element in the left sub-array (`nums[i]`), we move a pointer `right` in the right sub-array to find the maximum number of elements that satisfy the condition $\text{nums}[i] > 2 \times \text{nums}[right]$. 
    *   Since the elements in the left sub-array are increasing, as $i$ increases, the required `right` pointer position will also move monotonically forward, ensuring that the `countPairs` function runs in linear time relative to the size of the current sub-array.
3.  **Merge (The `merge` function)**: Once the pairs are crossing the boundary are counted, the standard Merge Sort `merge` step is performed to sort the sub-arrays and pass them up the recursion tree.

### **Key Implementation Details**

*   **Overflow Prevention**: The condition `(long) nums[i] > 2L * nums[right]` is crucial. Multiplying an integer by 2 can easily cause an integer overflow if `nums[right]` is a large value. Casting to `long` ensures the calculation is performed with 64-bit precision.
*   **Monotonicity**: The two-pointer approach works because if $nums[i] > 2 	imes nums[right]$, then for any $i' > i$ (where $nums[i'] 	ext{ is in a sorted sub-array}$), $nums[i']$ is also very likely to satisfy the condition for the same $right$. However, the pointer `right` does not reset for each $i$; it only advances, maintaining linear complexity for the `countPairs` step.

## 3. **Complexity Analysis**

### **Time Complexity**
*   **Divide phase**: The array is split $\log N$ times.
*   **Count phase**: In each level of the recursion, the `countPairs` function iterates through the sub-arrays using a two-pointer technique, which is effectively $O(N)$ per level. 
*   **Merge phase**: The standard merge step also takes $O(N)$ per level.
*   **Total Time Complexity**: $O(N \log N)$, where $N$ is the length of the array. This is significantly faster than the $O(N^2)$ brute force approach.

### **Space Complexity**
*   **Auxiliary Space**: $O(N)$ to store the `temp` array used during the merge process. 
*   **Recursion Stack**: $O(\log N)$ for the recursion depth. 
*   **Total Space Complexity**: $O(N)$.

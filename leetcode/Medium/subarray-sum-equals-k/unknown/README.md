# 560. Subarray Sum Equals K

- **Platform:** leetcode
- **Difficulty:** Medium
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/subarray-sum-equals-k/description/)

## Solution Notes

# 560. Subarray Sum Equals K

## 1. **Brute Force Approach**

A brute force approach involves iterating through every possible subarray within the given array `nums`. This is achieved using two nested loops: the outer loop marks the starting index `i` of the subarray, and the inner loop marks the ending index `j`. For every subarray defined by `[i, j]`, the sum of its elements is calculated. If this sum equals the target `k`, the total count of such subarrays is incremented.

## 2. **Optimal Approach**

*Note: The provided code implements the **Brute Force** approach, not the optimal approach. The optimal solution for this problem typically involves using a Prefix Sum combined with a Hash Map to reduce time complexity.
*

### Implementation Details of the Provided Code:
In the provided implementation, the code uses a nested loop structure to exhaustively check all subarrays:
1. The outer loop `for (int i = 0; i < nums.length; i++)` iterates through each element as a potential starting point of a subarray.
2. The inner loop `for (int j = i; j < nums.length; j++)` iterates from the current starting point `i` to the end of the array, effectively expanding the subarray one element at a time.
3. A variable `sum` is keeps track of the running total of elements from index `i` to index `j`.
4. For every index `j`, the code checks if the current `sum` equals `k`. If it does, `count` is incremented.
5. After the inner loop completes for a specific `i`, the outer loop moves to the next starting index.

## 3. **Complexity Analysis**

### Time Complexity
- **O(N²)**: Where `N` is the length of the array `nums`. The algorithm uses two nested loops. The outer loop runs `N` times, and for each iteration of the outer loop, the inner loop runs approximately `N - i` times. This leads to a quadratic time complexity.

### Space Complexity
- **O(1)**: The algorithm only uses a constant amount of extra space for the variables `count` and `sum`, regardless of the input size.

## 4. **Dry Run**

**Input:** `nums = [1, 1, 1], k = 2`

| Step | i | j | nums[j] | Current Sum | sum == k? | count | 
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | 
| 1 | 0 | 0 | 1 | 1 | No | 0 | 
| 2 | 0 | 1 | 1 | 2 | Yes | 1 | 
| 3 | 0 | 2 | 1 | 3 | N/A | 1 | 
| 4 | 1 | 1 | 1 | 1 | No | 0 | 
| 5 | 1 | 2 | 1 | 2 | Yes | 1 | 
| 6 | 2 | 2 | 1 | 1 | No | 0 | 
| 7 | 8 | 9 | N/A | N/A | N/A | 1 | 

*Wait, let's correct the dry run trace table for clarity and flow:* 

**Input:** `nums = [1, 2, 3], k = 3` 

| Step | i | j | nums[j] | Current Sum | sum == k? | count | 
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | 
| 1 | 0 | 0 | 1 | 1 | No | 0 | 
| 2 | 0 | 1 | 2 | 3 | Yes | 1 | 
| 3 | 0 | 2 | 3 | 6 | No | 1 | 
| 4 | 1 | 1 | 2 | 2 | i/a | 0 | 
| 5 | 1 | 2 | 3 | 5 | No | 1 | 
| 6 | 2 | 2 | 3 | 3 | Yes | 2 | 

**Final Result:** `count = 2`

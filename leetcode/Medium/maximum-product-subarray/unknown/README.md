# 152. Maximum Product Subarray

- **Platform:** leetcode
- **Difficulty:** Medium
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/maximum-product-subarray/submissions/2074952548/)

## Solution Notes

# 152. Maximum Product Subarray

## 1. **Brute Force Approach**

To solve this problem using a brute force method, one would iterate through every possible subarray within the given array. This involves using nested loops: an outer loop to determine the starting index and an inner loop to determine the ending index of the subarray. For each subarray, the product of all its elements is calculated. The maximum product found among all these subarrays is then returned as the result. This approach is significantly inefficient due to the redundant recalculations of products.

## 2. **Optimal Approach**


The optimal approach utilizes a dynamic programming concept, specifically maintaining running trackers for both the maximum and minimum products ending at the current position. This is necessary because thes product of a negative number and a negative number results in a positive number. Therefore, the minimum product (which could be a large negative value) can potentially become the maximum product when multiplied by another negative number.

### Key Logic Steps:

1. **Initialization**: Initialize `maxProd`, `minProd`, and `res` with the first element of the array (`nums[0]`).
2. **Iteration**: Loop through the array starting from the second element (index 1).
3. **Handling Negative Numbers**: 
   - If the current element `curr` is negative, the potential maximum product and the minimum product will switch roles. A large positive product multiplied by a negative number becomes a small negative number, and a large negative product multiplied by a negative number becomes a large positive number. 
   - To handle this swap, a temporary variable `temp` is used to store the `maxProd` before it is updated, allowing for a swap between `maxProd` and `minProd`.
4. **Updating Products**:
   - `maxProd` is updated to be the maximum of either the current element itself or the current element multiplied by the previous `maxProd`.
   - `minProd` is updated to be the minimum of either the current element itself or the current element multiplied by the previous `minProd`.
   - This effectively handles cases where a subarray restarts at the current element (e.g., when the previous products were zero or very small).
5. **Global Maximum**: The result `res` is updated at each step by taking the maximum of the current `res` and the current `maxProd`.

## 3. **Complexity Analysis**

### Time Complexity
- **O(N)**: The algorithm traverses the array exactly once in a single loop, where $N$ is the number of elements in the array. Each operation within the loop (comparisons, multiplications, swaps) is constant time.

### Space Complexity
- **O(1)**: The algorithm only uses a few scalar variables (`maxProd`, `minProd`, `res`, `curr`, `temp`) to keep track of state, regardless of the size of input array. No additional data structures are allocated.


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



## AI Solution Notes

# 152. Maximum Product Subarray

## 1. **Brute Force Approach**

To solve this problem using a brute force method, one would iterate through every possible subarray within the given array `nums`. For each subarray, you would calculate its product and keep track of the maximum product encountered. This involves two nested loops: the outer loop defines the start of the subarray and the outer loop defines the end of the subarray. This approach is computationally expensive and inefficient for large input arrays due to its high time complexity.

## 2. **Optimal Approach**

The provided solution implements an optimal dynamic programming approach that tracks both the maximum and minimum products at each position. This is necessary because thes a single negative number can turn a large positive product into a small negative one, and conversely, a large negative product can become a large positive product when multiplied by another negative number.

### Key Logic:
1. **Initialization**: The variables `maxProd`, `minProd`, and `res` are all initialized to the first element of the array `nums[0]`. This ensures that the algorithm handles single-element arrays correctly.
2. **Tracking Two States**: Unlike the Maximum Sum Subarray problem (Kadane's Algorithm), where we only track the maximum sum, here we must track both the `maxProd` and `minProd` because a negative number multiplied by a negative number results in a positive number. 
3. **Handling Negative Numbers**: When the current element `curr` is negative, the potential for a large positive product and a large negative product swaps. Therefore, we swap `maxProd` and `minProd` before performing the calculations. This prevents the need for complex conditional logic during the multiplication step.
4. **Updating Products**: 
   - `maxProd = Math.max(curr, maxProd * curr)`: This updates the `maxProd` to be either the current element itself (starting a new subarray) starting a new subarray or the current element multiplied by the previous maximum product.
   - `minProd = Math.min(curr, minProd * curr)`: Similarly, this updates the `minProd` to either the current element itself or the current element multiplied by the previous minimum product.
   - `res = Math.max(res, maxProd)`: Finally, we update the global maximum `res` at each step to ensure we capture the peak product value observed during the iteration.

## 3. **Complexity Analysis**

### Time Complexity
- **O(n)**: The algorithm iterates through the array exactly once, where `n` is the number of elements in `nums`. Every operation within the loop (swapping, multiplication, and comparison) is constant time $O(1)$.

### Space Complexity
- **O(1)**: The algorithm uses a constant amount of extra space to store variables `maxProd`, `minProd`, `res`, and `temp`, regardless of the input size.

## 4. **Dry Run**

**Input**: `nums = [2, 3, -2, 4, -1]`

1. **Initialization**:
   - `maxProd = 2`, `minProd = 2`, `res = 2` 

2. **Iteration 1** (`i = 1`, `curr = 3`):
   - `curr` is not negative, so no swap.
   - `maxProd = max(3, 2 * 3) = 6` 
   - `minProd = min(3, 2 * 3) = 6` (Wait, `minProd` becomes 6? No, let's recalculate: `minProd = min(3, 2 * 3) = 3`. Let's re-check the logic: `minProd = min(3, 6) = 3`)
   - Correction: `minProd = min(3, 6) = 3` 
   - `res = max(2, 6) = 6` 

3. **Iteration 2** (`i = 2`, `curr = -2`):
   - `curr < 0`, so swap `maxProd` and `minProd`: `maxProd = 3`, `minProd = 6` 
   - `maxProd = max(-2, 3 * -2) = -2` 
   - `minProd = min(-2, 6 * -2) = -12` 
   - `res = max(6, -2) = 6` 

4. **Iteration 3** (`i = 3`, `curr = 4`):
   - `nums[3] = 4`
   - `maxProd = max(4, -2 * 4) = 4` 
   - `minProd = min(4, -12 * 4) = -48` 
   - `res = max(6, 4) = 6` 

5. **Iteration 4** (`i = 4`, `curr = -1`):
   - `curr < 0`, so swap `maxProd` and `minProd`: `maxProd = -48`, `minProd = 4` 
   - `maxProd = max(-16, -48 * -1) = 48` (Wait, checking math: `max(-1, -48 * -1) = 48`. No, `max(-1, 48) = 48`)
   - `maxProd = max(-1, 48) = 48` 
   - `minProd = min(-1, 4 * -1) = -4` 
   - `res = max(6, 48) = 48` 

**Final Result**: `48`

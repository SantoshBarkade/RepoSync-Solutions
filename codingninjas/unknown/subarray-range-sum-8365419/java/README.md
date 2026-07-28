# Unknown Problem

- **Platform:** codingninjas
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.naukri.com/code360/problems/subarray-range-sum_8365419?leftPanelTabValue=SUBMISSION)

## Solution Notes

## 1. **Brute Force Approach**

A naive approach to solving this problem would involve iterating through every possible subarray and calculating its sum. For an array of size $N$, there are $O(N^2)$ subarrays. For each subarray, calculating the sum would take $O(N)$ or $O(1)$ if using prefix sums. The total complexity would be thus $O(N^2)$ to find the sum of all subarrays, find the maximum subarray sum, and find the minimum subarray sum, and then return their difference. However, given the nature of the problem (finding the sum of all subarray sums), a brute force approach is inefficient for large arrays.

## 2. **Optimal Approach**

This solution utilizes a monotonic stack to efficiently calculate the contribution of each element `nums[i]` to the total sum of all subarray sums and the total sum of all subarray minimums and maximums. Specifically, the problem is framed as: finding the $\sum (\text{subarray max}) - \sum (\text{subarray min})$. This is equivalent to $\sum (\text{subarray max} - \text{subarray min})$.

To achieve $O(N)$ complexity, we calculate the contribution of each element as the maximum element in how many subarrays it belongs to, and as the minimum element in how many subarrays it belongs to.

### Steps:

1.  **Calculate Contribution to Max Sum**: For each element `nums[i]`, we find the indices of the nearest elements to its left and right that are strictly greater than it. To avoid double-counting subarrays when elements are equal, we use a strict comparison on one side and a non-strict comparison on the other.
    *   `prevGreater[i]`: Index of the nearest element to the left such that `nums[prevGreater[i]] > nums[i]`.
    *   `nextGreater[i]`: Index of the nearest element to the right such that `nums[nextGreater[i]] >= nums[i]` (using non-strict to handle duplicates).
    *   The number of subarrays where `nums[i]` is the maximum is calculated by: `(i - prevGreater[i]) * (nextGreater[i] - i)`.

2.  **Calculate Contribution to Min Sum**: Similarly, for each element `nums[i]`, we find the indices of the nearest elements to its left and right that are strictly smaller than it.
    *   `prevSmaller[i]`: Index of the nearest element to the left such that `nums[prevSmaller[i]] < nums[i]`.
    *   `nextSmaller[i]`: Index of the nearest element to the right such that `/nums[nextSmaller[i]] <= nums[i]` (using non-strict to handle duplicates).
    *   The number of subarrays where `nums[i]` is the minimum is calculated by: `(i - prevSmaller[i]) * (nextSmaller[i] - i)`.

3.  **Summing Contributions**: 
    *   `maxSum += nums[i] * (number of subarrays where nums[i] is max)`.
    *   `minSum += nums[i] * (number of battles where nums[i] is min)`.

4.  **Handling Duplicates**: The use of `nums[st.peek()] <= nums[i]` for the previous greater and `nums[st.peek()] < nums[i]` for the next greater (and vice versa for smaller) is a critical part of the logic to ensure that if multiple elements in a subarray have the same maximum/minimum value, only one of them is 

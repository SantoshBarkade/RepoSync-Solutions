# 704. Binary Search

- **Platform:** leetcode
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/binary-search/submissions/2066428299/)

## Solution Notes


## AI Solution Notes

### Brute Force Approach
The brute force approach involves performing a linear search by iterating through every element of the array from index `0` to `n-1`. By comparing each element with the target value, you can return the index if a match is found, or return `-1` if the loop finishes without finding the target. This approach has a time complexity of O(n).

### Optimal Approach
The provided solution utilizes the Binary Search algorithm, which is highly efficient for sorted arrays. It works by repeatedly dividing the search interval in half:
1. **Initialization**: Set `low` to the start of the array (index 0) and `high` to the end of the array (index `nums.length - 1`).
2. **Midpoint Calculation**: Calculate the `mid` index using `low + (high - low) / 2` to prevent potential integer overflow.
3. **Comparison**:
   - If `nums[mid]` equals the `target`, the target is found; return `mid`.
   - If `nums[mid]` is less than the `target`, the target must be in the right half of the current interval. Update `low` to `mid + 1`.
   - If `nums[mid]` is greater than the `target`, the target must be in the left half of the current interval. Update `high` to `mid - 1`.
4. **Termination**: The process repeats while `low <= high`. If the loop exits, the target does not exist in the array, and the function returns `-1`.

### Complexity Analysis
- **Time Complexity**: O(log n), where n is the number of elements in the array. Since the search range is halved in every iteration, the number of steps grows logarithmically relative to the input size.
- **Space Complexity**: O(1), as the algorithm uses a constant amount of extra space for pointers (`low`, `high`, `mid`) regardless of the input size.

### Dry Run
Input: `nums = [-1, 0, 3, 5, 9, 12]`, `target = 9`

1. **Iteration 1**:
   - `low = 0`, `high = 5`
   - `mid = 0 + (5-0)/2 = 2`
   - `nums[2]` is `3`. Since `3 < 9`, set `low = mid + 1 = 3`.
2. **Iteration 2**:
   - `low = 3`, `high = 5`
   - `mid = 3 + (5-3)/2 = 4`
   - `nums[4]` is `9`. Since `9 == 9`, return `mid` (4).

Result: `4`

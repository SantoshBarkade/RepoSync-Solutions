# 1. Two Sum

- **Platform:** leetcode
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/two-sum/)

## Solution Notes


## AI Solution Notes

1. **Brute Force Approach**
The brute force approach involves using two nested loops to iterate through every possible pair of elements in the array. For each element at index `i`, you check all subsequent elements at index `j` to see if their sum equals the `target`. This results in a time complexity of O(n²).

2. **Optimal Approach**
The provided optimal approach uses a `HashMap` to store numbers as keys and their corresponding indices as values. As we iterate through the array once, we calculate the `complement` (which is `target - current_value`). We check if this complement already exists in the map. If it does, we have found the pair and return their indices. If not, we store the current element and its index in the map and continue. This allows us to find the solution in a single pass.

3. **Complexity Analysis**
*   **Time Complexity**: O(n), where `n` is the number of elements in the array. We traverse the list containing `n` elements only once, and each lookup in the `HashMap` takes O(1) average time.
*   **Space Complexity**: O(n), as we potentially store up to `n` elements in the `HashMap` in the worst-case scenario.

4. **Dry Run**
Example: `nums = [2, 7, 11, 15]`, `target = 9`

*   **Iteration 0**: `i = 0`, `nums[0] = 2`. Complement = `9 - 2 = 7`. Map is empty, so `7` is not found. Map: `{2: 0}`.
*   **Iteration 1**: `i = 1`, `nums[1] = 7`. Complement = `9 - 7 = 2`. `2` is found in the map at index `0`. 
*   **Return**: `new int[]{0, 1}`.

# Subarrays with sum K

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1)

## Solution Notes

# Subarrays with Sum K

## 1. **Brute Force Approach**

The brute force approach involves checking every possible subarray within the given array. This is typically achieved using nested loops: 
1. The outer loop determines the starting index of the subarray.
2. The second loop iterates through all possible ending indices for that starting index.
3. A third loop (or a running sum) calculates the sum of the elements in that specific subarray.

If the calculated sum equals `k`, the counter is incremented. This approach is highly inefficient for large arrays due to its cubic or quadratic time complexity.

## 2. **Optimal Approach**

The optimal approach utilizes the **Prefix Sum** technique combined with a **HashMap** to achieve linear time complexity. 

### Core Logic

A subarray sum from index `i` to `j` can be expressed as:
`Sum(i, j) = PrefixSum(j) - PrefixSum(i - 1)`

To find a subarray where the sum equals `k`, we need to solve for:
`k = PrefixSum(j) - PrefixSum(i - 1)`
Rearranging this formula, we get:
`PrefixSum(i - 1) = PrefixSum(j) - k`

As we iterate through the array, we maintain a running `sum` (which represents the `PrefixSum` up to the current index `j`). At each step, we check if the value `(sum - k)` has been encountered before as a prefix sum. If it has, the frequency of `(sum - k)` in our HashMap indicates how many previous starting points `i` exist such that the subarray from `i` to `j` sums to `k`.

### Implementation Details

1. **HashMap Initialization**: We initialize a `HashMap<Integer, Integer>` where the key is the `PrefixSum` and the value is the `Frequency` of that prefix sum.
2. **Base Case**: We perform `map.put(0, 1)`. This is crucial because if the `PrefixSum` itself equals `k` at some index, `sum - k` will be `0`. The `1` represents that a sum of zero has occurred once (at the very beginning, before any elements are elements).
3. **Iteration**: For each element in the array:
    - Update the cumulative `sum`.
    - Check if `sum - k` exists in the map. If it does, add its frequency to the `count`.
    - Update the map with the current `sum`. If the `sum` already exists, increment its frequency; otherwise, add it with a value of `1`.
4. **Return**: The final `count` holds the total number of subarrays that sum up to `k`.

## 3. **Complexity Analysis**

### Time Complexity
- **Complexity**: $O(N)$, where $N$ is the number of elements in the array.
- **Reasoning**: We traverse the array exactly once. Inside the loop, HashMap operations (`containsKey`, `get`, `put`, `getOrDefault`) take $O(1)$ time on average. Therefore, the total time spent is proportional to the number of elements.

### Space Complexity
- **Complexity**: $O(N)$
- **Reasoning**: In the worst case (e.g., an array with all positive numbers), the prefix sum grows monotonically, and every unique prefix sum is stored in the HashMap. This requires $O(N)$ additional space to store these sums in the map.

## 4. **Dry Run**

**Example Input**: `arr = [1, 2, 3]`, `k = 3` 

| Index | Element | Running Sum (`sum`) | `sum - k` | Map (Before Update) | Map (After Update) | Count (`count`) |
|---|---|---|---|---|---|---|
| Initial | - | 0 | - | `{0: 1}` | `{0: 1}` | 0 |
| 0 | 1 | 1 | $1-3 = -2$ | `{0: 1}` | `{0: 1, 1: 1}` | 0 |
| 1 | 2 | 3 | $3-3 = 0$ | `{0: 1, 1: 1}` | `{0: 1, 1: 1, 3: 1}` | 1 (found 0) |
| 2 | 3 | 1 | $1-3 = -2$ | `{0: 1, 1: 1, 3: 1}` | `{0: 1, 1: 1, 3: 1, 6: 1}` | 1 (no match) |

**Wait, let's re-calculate the dry run carefully:**

**Input**: `arr = [1, 2, 3]`, `k = 3` 

1. **Initialization**: `map = {0: 1}`, `sum = 0`, `count = 0`.
2. **Index 0 (val=1)**: 
    - `sum = 1`.
    - `sum - k` = $1 - 3 = -2$. Not in map.
    - Update map: `map = {0: 1, 1: 1}`.
3. **Index 1 (val=2)**: 
    - `sum = 3`.
    - `sum - k` = $3 - 3 = 0$. **0 is in map!**
    - `count = count + map.get(0)` $ightarrow$ $0 + 1 = 1$.
    - Update map: `map = {0: 1, 1: 1, 3: 1}`.
4. **Index 2 (val=3)**: 
    - `sum = 6` (Wait, I calculated $1+2+3=6$). 
    - `sum - k` = $6 - 3 = 3$. **3 is in map!**
    - `count = count + map.get(3)` $ightarrow$ $1 + 1 = 2$.
    - Update map: `map = {0: 1, 1: 1, 3: 1, 6: 1}`.

**Final Count**: 2 (Subarrays: `[1, 2]` and `[3]`).

# 118. Pascal's Triangle

- **Platform:** leetcode
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/pascals-triangle/submissions/1959172295/)

## Solution Notes

# 118. Pascal's Triangle

## 1. **Brute Force Approach**
In a brute force context, one might attempt to generate Pascal's Triangle by using the mathematical formula for combinations, where each element at row $n$ and column $k$ is calculated as $\binom{n}{k} = \frac{n!}{k!(n-k)!}$. While this correctly produces the values, calculating factorials for large $n$ leads to integer overflow and significant computational overhead due to redundant calculations of the values used in previous rows.

## 2. **Optimal Approach**
The provided solution implements a dynamic programming approach by utilizing the additive property of Pascal's Triangle: each interior element is the sum of the two elements directly above it in the preceding row. 

### Implementation Details:
1. **Initialization**: An empty list of lists `triangle` is initialized to store the resulting rows.
2. **Outer Loop (Row Generation)**: The loop iterates from `i = 0` up to `numRows - 1`. Each iteration represents the creation of a new row.
3. **Inner Loop (Element Generation)**: For each row `i`, a nested loop iterates from `j = 0` to `i`. 
    - **Boundary Conditions**: If `j == 0` (the first element of the row) or `j == i` (the last element of the row), the value is hardcoded to `1`.
    - **Recurrence Relation**: For all other elements where `0 < j < i`, the value is calculated as: 
      `row[j] = triangle[i-1][j-1] + triangle[i-1][j]`. 
      This looks at the previous row (`i-1`) and sums the elements at indices `j-1` and `j`.
4. **Row Completion**: Once the inner loop finishes, the current `row` list is added to the `triangle` list.

## 3. **Complexity Analysis**

### Time Complexity
- **Complexity**: $O(N^2)$, where $N$ is `numRows`.
- **Explanation**: We use two nested loops. The outer loop runs $N$ times. The inner loop runs $1, 2, 3, ..., N$ times. The total number of operations is the sum of the first $N$ integers: $\sum_{i=1}^{N} i = \frac{N(N+1)}{2}$, which simplifies to $O(N^2)$.

### Space Complexity
- **Complexity**: $O(N^2)$ (or $O(1)$ if we exclude the output storage).
- **Explanation**: We store the entire triangle in a 2D list structure. Since there are $\frac{N(N+1)}{2}$ elements in the triangle, the space required to store the output is $O(N^2)$. Excluding the output, the auxiliary space used by the algorithm is $O(1)$ (beyond the list used to build the current row).

## 4. **Dry Run**
**Input**: `numRows = 5`

| Row Index (`i`) | Inner Loop (`j`) | Logic | Value Added | Current `row` | `triangle` State |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 0 | 0 | `j == 0` | 1 | `[1]` | `[[1]]` |
| 1 | 0 | `j == 0` | 1 | `[1, 1]` | `[[1], [1, 1]]` |
| 1 | 1 | `j == 1` | 1 | `[1, 1]` | `[[1], [1, 1]]` |
| 2 | 0 | `j == 0` | 1 | `[1, 1, 1]` | `[[1], [1, 1], [1, 1, 1]]` (Incorrect logic in table row - correction below) |
| 2 | 0 | `j == 0` | 1 | `[1]` | | |
| 2 | 1 | `j == 1` | `tri[1][0] + tri[1][1]` | `1 + 1 = 2` | `[1, 2]` | |
| 2 | 2 | `j == 2` | `j == i` | 1 | `[1, 2, 1]` | `[[1], [1, 1], [1, 2, 1]]` |
| 3 | 0 | `j == 0` | 1 | `[1]` | | |
| 3 | 1 | `j == 1` | `tri[2][0] + tri[2][1]` | `1 + 2 = 3` | `[1, 3]` | | |
| 3 | 2 | `j == 2` | `tri[2][1] + tri[2][2]` | `2 + 1 = 3` | `[1, 3, 3]` | | |
| 3 | 3 | `j == 3` | `j == i` | 1 | `[1, 3, 3, 1]` | `[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]` |
| 4 | 0 | `j == 0` | 1 | `[1]` | | |
| 4 | 1 | `j == 1` | `tri[3][0] + tri[3][1]` | `1 + 3 = 4` | `[1, 4]` | | |
| 4 | 2 | `j == 2` | `j == 2` (Wait, `j` index is 2) | `tri[3][1] + tri[3][2]` | `3 + 3 = 6` | `[1, 4, 6]` | | |
| 4 | 3 | `j == 3` | `tri[3][2] + tri[3][3]` | `3 + 1 = 4` | `[1, 4, 6, 4]` | | |
| 4 | 4 | `j == 4` | `j == i` | 1 | `[1, 4, 6, 4, 1]` | `[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]` |

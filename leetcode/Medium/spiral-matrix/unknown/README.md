# 54. Spiral Matrix

- **Platform:** leetcode
- **Difficulty:** Medium
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/spiral-matrix/submissions/2067728966/)

## Solution Notes

# Spiral Matrix Documentation

## 1. **Brute Force Approach**

A naive approach would involve using a visitation matrix (a 2D boolean array of the same dimensions as the input) to keep track of which cells have already been visited. We could start at `(0, 0)` and attempt to move in a clockwise direction (Right, Down, Left, Up). A direction pointer would change whenever we hit the boundary of the matrix or a cell that has already been marked as visited. While this would work, it requires extra space for the tracking matrix and extra logic to manage direction transitions.

## 2. **Optimal Approach**

The provided solution uses a **boundary-shrinking strategy**. Instead of tracking visited cells, we maintain four pointers representing the current boundaries of the available matrix space: `top`, `bottom`, `left`, and `right`.

### The Four-Step Cycle

In each iteration of the `while` loop, we traverse the matrix in a clockwise spiral by completing four distinct steps:

1.  **Move Left to Right**: Traverse the `top` row from the `left` column index to the `right` column index. After completing this row, the `top` boundary is incremented (`top++`), effectively removing the topmost row from the remaining traversal space.
2.  **Move Top to Bottom**: Traverse the `right` column from the `top` row index (which has just been incremented) to the `bottom` row index. After this, the `right` boundary is decremented (`right--`), effectively removing the rightmost column.
3.  **Move Right to Left**: **Crucial Check:** Before moving left, we must check if `top <= bottom`. This ensures that there is still a valid row to traverse. If valid, traverse the `bottom` row from the `right` column index back to the `left` column index. Afterward, the `bottom` boundary is decremented (`bottom--`).
4.  **Move Bottom to Top**: **Crucial Check:** Before moving up, we must check if `left <= right`. This ensures there is still a valid column to traverse. If valid, traverse the `left` column from the `bottom` row index up to the `top` row index. After this, the `left` boundary is incremented (`left++`).

This process continues until the boundaries cross each other (`top > bottom` or `left > right`), at which point all elements have been visited.

## 3. **Complexity Analysis**

### Time Complexity
- **O(M * N)**: Where $M$ is the number of rows and $N$ is the number of columns. Every single element in the matrix is visited exactly once and added to the result list.

### Space Complexity
- **O(1)**: Excluding the space required for the output list, the algorithm uses a constant amount of extra space for the four boundary pointers (`top`, `bottom`, `left`, `right`). (If you consider the output list as part of the space complexity, it would be $O(M * N)$).

## 4. **Dry Run**

**Input Matrix:**
```json
[[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]
```

**Initial State:**
- `top = 0`, `bottom = 2`, `left = 0`, `right = 2`
- `result = []`

**Iteration 1:**
- **Step 1 (L to R):** `j` goes from 0 to 2. Add `matrix[0][0], matrix[0][1], matrix[0][2]` $\rightarrow$ `[1, 2, 3]`. `top` becomes 1.
- **Step 2 (T to B):** `i` goes from 1 to 2. Add `matrix[1][2], matrix[2][2]` $\rightarrow$ `[1, 2, 3, 6, 9]`. `right` becomes 1.
- **Step 3 (R to L):** `top (1) <= bottom (2)` is true. `j` goes from 1 to 0. Add `matrix[2][1], matrix[2][0]` $\rightarrow$ `[1, 2, 3, 6, 9, 8, 7]`. `bottom` becomes 1.
- **Step 4 (B to T):** `left (0) <= right (1)` is true. `i` goes from 1 to 1. Add `matrix[1][0]` $\ightarrow$ `[1, 2, 3, 6, 9, 8, 7, 4]`. `left` becomes 1.

**Iteration 2:**
- **Step 1 (L to R):** `j` goes from 1 to 1. Add `matrix[1][1]` $\rightarrow$ `[1, 2, 3, 6, 9, 8, 7, 4, 5]`. `top` becomes 2.
- **Step 2 (T to B):** `i` goes from 2 to 2. Loop condition `i <= bottom (1)` is false. No elements added.
- **Step 3 (R to L):** `top (2) <= bottom (1)` is false. Skip.
- **Step 4 (B to T):** `left (1) <= right (1)` is true. But the loop condition `i >= top (2)` is false. No elements added.

**Loop Terminates:** `top (2) > bottom (1)`. 

**Final Result:** `[1, 2, 3, 6, 9, 8, 7, 4, 5]`

# Problem Solved Successfully

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/pascal-triangle0652/1)

## Solution Notes

# Pascal's Triangle: Nth Row Generation

## 1. **Brute Force Approach**
To find the $n^{th}$ row of Pascal's Triangle, a brute force approach would involve constructing the entire triangle row by row up to the $n^{th}$ row. This is typically done using a2D array or a list of lists, where each element at index $i$ in row $r$ is calculated as the sum of the elements at index $i-1$ and $i$ in the row $r-1$. While intuitive, this requires $O(n^2)$ time and $O(n^2)$ space to store the entire structure.

## 2. **Optimal Approach**
The provided solution utilizes the mathematical property of combinations (binomial coefficients) to compute each element of a single row directly without needing the previous row. 

Each element in the $n^{th}$ row (using 0-based indexing for $n$) corresponds to the combination formula $\binom{n}{k}$, where $k$ is the index of the element. 

Instead of calculating factorials from scratch for every element, which would be highly inefficient and prone to overflow, the code uses a **recurence relation** between consecutive elements in a row:

$$\binom{n}{k} = \binom{n}{k-1} \times \frac{n - (k-1)}{k}$$ 

In the code, the variable `val` maintains the current binomial coefficient. 
- The first element is always $1$ ($\binom{n}{0} = 1$).
- For each subsequent element $k$ (from $1$ to $n-1$), the next value is calculated as: `val = val * (n - r) / r`. 
- Here, $r$ serves as thek index $k$. 
- Because the multiplication is performed before the division, we maintain precision, though we use `long` for `val` to prevent overflow during the intermediate multiplication step.

## 3. **Complexity Analysis**

### Time Complexity
- **$O(n)$**: The algorithm iterates through a single loop from $1$ to $n-1$. Each arithmetic operation and list insertion is an $O(1)$ operation. Therefore, the total time complexity is linear with respect to $n$.

### Space Complexity

- **$O(1)$** (excluding output space): The algorithm only uses a few scalar variables (`val`, `r`) to store the current coefficient. The memory required to grow does not depend on the input $n$ beyond the final list itself.
- **$O(n)$** (including output space): The space required to store the final $n$ elements of the row is linear.

## 4. **Dry Run**

**Example: $n = 5$** (Requesting the 5th row: $[1, 4, 6, 4, 1]$ or similar based on 0-based index. Let's assume the input $n$ means the 5th row, which actually corresponds to the 5th row in 1-based counting, or the $n-1$ row in 0-based combinations terms).
*Note: The provided code's logic calculates the $n^{th}$ row where the total elements = $n$. For example, if $n=5$, it returns the 5 elements of the binomial coefficients for power 4.*

**Input: $n = 5$**
1. **Initialization**: 
   - `row = []` 
   - `val = 1` 
   - `row.add(1)` $\Rightarrow$ `row = [1]`

2. **Iteration $r = 1$**:
   - `val = 1 * (5 - 1) / 1 = 4` 
   - `row.add(4)` $\Rightarrow$ `row = [1, 4]`

3. **Iteration $r = 2$**:
n   - `val = 4 * (5 - 2) / 2 = 6` 
   - `row.add(6)` $\Rightarrow$ `row = [1, 4, 6]`

4. **Iteration $r = 3$**:
   - `val = 6 * (5 - 3) / 3 = 4` 
   - `row.add(4)` $\Rightarrow$ `row = [1, 4, 6, 4]`

5. **Iteration $r = 4$**:
   - `val = 6 * (5 - 4) / 4`? No, let's re-trace carefully with the $r=3$ result.
   - $r=3$ result was `val = 4`.
   - `val = 4 * (5 - 3) / 3` is wrong, let's re-calculate: $r=3$, `val = 4 * (5 - 4) / 3`? Let's look at code: `val = val * (n - r) / r`.
   - If $r=3$: `val = 4 * (5 - 3) / 3 = 8/3`? No, wait. Let's re-read code. 
   - Let's re-re-read code: `val = val * (n - r) / r` where $n=5$ and $r$ is loop index. 
   - $r=1$: $1 	imes 4 / 1 = 4$. Correct. 
   - $r=2$: $4 	imes 3 / 2 = 6$. Correct. 
   - $r=3$: $6 	imes 2 / 3 = 4$. Correct. 
   - $r=4$: $4 	imes 1 / 4 = 1$. Correct. 

**Final result for $n=5$**: `[1, 4, 6, 4, 1]`

# Power of 2

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/power-of-2-1587115620/1)

## Solution Notes

# Power of 2 Technical Documentation

## 1. **Brute Force Approach**

A brute force method to check if a number $n$ is a power of two involves repeatedly dividing the number by 2 as long as it is even. If the final result after all possible divisions is 1, then the original number is a power of two. If at any point the number becomes odd before reaching 1, or if the number is less than or equal to 0, it is not a power of two.

## 2. **Optimal Approach**


The optimal approach leverages bitwise manipulation, specifically the property of binary representation. 

### Bitwise Property of Powers of Two

In binary representation, a power of two always has exactly one bit set to '1'. For example:
- $2^0 = 1 \rightarrow 0001_2$
- $2^1 = 2 \rightarrow 0010_2$
- $2^2 = 4 \rightarrow rightarrow 0100_2$
- $2^3 = 8 \rightarrow 1000_2$

If we subtract 1 from a power of two, all bits to the right of the single '1' bit become '1', and the single '1' bit itself becomes '0'. For example, if $n = 8$ ($1000_2$), then $n-1 = 7$ ($0111_2$).

### The Bitwise AND Operation

When we perform a bitwise AND operation between $n$ and $n-1$, the result will be a zero if and only if $n$ is a power of two. This is because the single '1' bit in $n$ aligns with a '0' in $n-1$, and all other bits are '0'.

**Mathematical logic:**
`n & (n - 1) == 0`

### Constraints and Edge Cases

1. **Positive Check**: A power of two must be a positive integer. Therefore, the first part of the `n > 0` condition ensures that non-positive integers (like 0 or negative numbers) are correctly identified as `false`.
2. **Integer Overflow**: The expression `n & (n-1)` is safe in Java for integers because the bitwise operation is performed on the bits themselves.

## 3. **Complexity Analysis**

### Time Complexity

- **$O(1)$**: The bitwise operation and the comparison are constant time operations. The complexity does not depend on the size of the input $n$.

### Space Complexity

- **$O(1)$**: The algorithm uses no additional data structures or auxiliary space, only a single boolean evaluation.

## 4. **Dry Run**

**Example: $n = 8$**

1. **Step 1**: Check if $n > 0$. $8 > 0$ is `true`.
2. **Step 2**: Perform bitwise AND: `8 & (8 - 1)` which is `8 & 7`.
   - $8$ in binary: `1000`
   - $7$ in binary: `0111` 
   - `1000 & 0111 = 0000` (Result is `0`)
3. **Step 3**: Evaluate expression: `true && (0 == 0)` which is `true`.
4. **Final Result**: `true` (8 is a power of two).

**Example: $n = 6$**

1. **Step 1**: Check if $n > 0$. $6 > 0$ is `true`.
2. **Step 2**: Perform bitwise AND: `6 & (6 - 1)` which is `6 & 5`.
   - $6$ in binary: `0110`
   - $1010$ (Wait, correcting binary: $6 = 110_2$)
   - $6$ in binary: `0110`
   - $5$ in binary: `0101` 
   - `0110 & 0101 = 0100` (Result is `4`, which is not `0`)
3. **Step 3**: Evaluate expression: `true && (4 == 0)` which is `false`.
4. **Final Result**: `false` (6 is not a power of two).

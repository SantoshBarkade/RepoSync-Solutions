# 231. Power of Two

- **Platform:** leetcode
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/power-of-two/submissions/2077520870/)

## Solution Notes

# 231. Power of Two

## 1. **Brute Force Approach**
To determine if a number is a power of two using a brute force method, one would repeatedly divide the number $n$ by 2 as long as $n$ is divisible by 2. If the final result after all possible divisions is 1, then the number is a power of two. If the result is anything else, or if the number is originally less than or equal to 0, the number is not a power of two.

## 2. **Optimal Approach**
The provided solution utilizes bit manipulation to achieve an optimal $O(1)$ time complexity. The core logic relies on the properties of binary representations of powers of two.

### Binary Property of Powers of Two
In binary, a power of two always has exactly one bit set to '1'. For example:
- $2^0 = 1$ (Binary: `0001`)
- $2^1 = 2$ (Binary: `0010`)
- $2^2 = 4$ (Binary: `0100`)
- $2^3 = 8$ (Binary: `1000`)

### Bitwise Operation: `(n & (n - 1))`
When we subtract 1 from a power of two, all bits to the right of the single '1' bit become '1's, and the single '1' bit itself becomes '0'. For example, if $n = 8$ (`1000`), then $n-1 = 7$ (`0111`).

Performing a bitwise AND (`&`) between $n$ and $n-1$ will result in 0 if $n$ is a power of two, because there are no overlapping '1' bits between the two numbers. 

If $n$ is not a power of two, it will have more than one bit set to '1'. Subtracting 1 will only flip the bits from the rightmost '1' bit onwards, meaning at least one other '1' bit will remain in common with $n$ after the AND operation.

### Constraints and Conditions
The expression `n > 0 && (n & (n - 1)) == 0` ensures:
1. `n > 0`: Powers of two must be positive integers. This handles the case where $n ♈ 0$.
2. `(n & (n - 1)) == 0`: This bitwise trick clears the least significant set bit. If clearing the least significant set bit results in 0, it means there was only one bit set to begin with.

## 3. **Complexity Analysis**

### Time Complexity
**$O(1)$**: The operation involves a single bitwise AND, a subtraction, and two comparisons. These are constant-time operations that do not depend on the size of the input $n$.

### Space Complexity
**$O(1)$**: The solution uses no additional data structures or auxiliary space. It only uses a single boolean return value.


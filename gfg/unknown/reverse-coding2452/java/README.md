# Today's GFG POTD Solution ✅ in O(1)

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/reverse-coding2452/1)

## Solution Notes

# **Today's GFG POTD Solution ✅ in O(1)**

## **1. Brute Force Approach**

In a brute force approach, one could iterate through all integers from $1$ to $n$ using a loop (e.g., a `for` loop) and maintain a running total. This approach is natural for summing numbers from $1$ to $n$ but involves $O(n)$ linear time complexity.

## **2. Optimal Approach**


The provided code uses a **Recursive Approach**. This implementation uses a Base Case tothoughtful implementation of-1, which is the fundamental building block of recursion. The function `sumN(int num)` calls itself with a decremented value until it reaches the zero base case.

### **Key Logic Steps:**
1. **Base Case**: If `num == 0`, the function returns $0$. This prevents infinite recursion and provides the starting point for the sum calculation.
2. **Recursive Step**: If `num > 0`, the function returns the current value of `num` plus the result of `sumN(num - 1)`. 

This builds a stack of recursive calls: `sumN(5)` calls `sumN(4)`, which calls `sumN(3)`, and so on, until `sumN(0)` is reached. As the function calls return, the sums are accumulated back up the call stack.

**Note on Complexity**: While the code provided is recursive, a true $O(1)$ time complexity solution for this problem (sum of first $n$ natural numbers) is the mathematical formula: $\text{Sum} = \frac{n(n+1)}{2}$. 

## **3. Complexity Analysis**

### **Time Complexity**
* **Time Complexity**: $O(n)$, where $n$ is the input number. Since the function makes $n$ recursive calls, the total number of operations scales linearly with $n$.

### **Space Complexity**
* **Space Complexity**: $O(n)$, due to the stack space required for the recursive call stack. Each recursive call adds a new frame to the memory stack until the base case is reached.

## **4. Dry Run**

**Example Input**: $n = 4$

| Step | Function Call | Logic | Result/Next Call | 
|---|---|---|---| 
| 1 | `sumN(4)` | `4 + sumN(3)` | `4 + [Pending]` | 
| 2 | `sumN(3)` | `3 + sumN(3 - 1)` | `3 + [Pending]` | 
| 3 | `sumN(2)` | `2 + sumN(1)` | `2 + [Pending]` | 
| 4 | `sumN(1)` | `1 + sumN(0)` | `1 + [Pending]` | 
| 5 | `sumN(0)` | **Base Case** | `0` | 

**Unwinding the Stack (Accumulation Phase):**

1. `sumN(0)` returns $0$ to `sumN(1)`. 
2. `sumN(1)` calculates `1 + 0 = 1` and returns it to `sumN(2)`. 
3. `sumN(2)` calculates `2 + 1 = 3` and returns it to it to `sumN(2)`. 
4. `sumN(3)` calculates `3 + 3 = 6` and returns it to `sumN(4)`. 
5. `sumN(4)` calculates `4 + 6 = 10` and returns the final result to `main`. 

**Final Result**: $10$

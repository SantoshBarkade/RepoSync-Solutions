# 509. Fibonacci Number

- **Platform:** leetcode
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/fibonacci-number/submissions/2083798832/)

## Solution Notes

# 509. Fibonacci Number

## 1. **Brute Force Approach**

To calculate the $n^{th}$ Fibonacci number using a brute force method, one typically employs a recursive approach based directly on the mathematical definition: $F(n) = F(n-1) + F(n-2)$. This involves building a recursive tree where each call branches into two more calls, leading to a massive amount of redundant calculations (e.g., calculating $F(n-3)$ multiple times across different branches). This approach is highly inefficient for larger values of $n$.

## 2. **Optimal Approach**

The provided solution implements an **Iterative Bottom-Up approach with Space Optimization**. 

Instead of working backward from $n$ using recursion, we start from the base cases ($0$ and $1$) and iteratively calculate the next number in the sequence until we reach $n$. To save space, rather than maintaining an entire array of size $n+1$ to store all previous Fibonacci numbers (as seen in standard Dynamic Programming), this algorithm only tracks the variables required to compute the current value.

### **Algorithm Steps:**
1. **Base Case Check**: If $n \le 1$, the function immediately returns $n$ (since $F(0)=0$ and $F(1)=1$).
2. **Variable Initialization**: We initialize two variables, `a` and `b`, to represent the two most recent numbers in the sequence. Initially, `a = 0` ($F(0)$) and `b = 1` ($F(1)$).
3. **Iterative Calculation**: We use a `for` loop starting from $i = 2$ up to $n$. 
    - Calculate the sum of the current two numbers: `c = a + b`.
    - Update the window: Move the value of `b` into `a` (the old $F(i-1)$ becomes the new $F(i-2)$).
    - Update the remainder: Move the value of `c` into `b` (the new sum becomes the current $F(i-1)$ for the next iteration).
4. **Return Result**: After the loop completes, `b` holds the value of the $n^{th}$ Fibonacci number.

## 3. **Complexity Analysis**

### **Time Complexity**
- **$O(n)$**: The algorithm consists of a single loop that iterates from $2$ to $n$. Each operation inside the loop (addition and assignment) is a constant time operation, resulting in a linear relationship between the input $n$ and the execution time.

### **Space Complexity**
- **$O(1)$**: The algorithm only uses a fixed number of integer variables (`a`, `b`, `c`, and `i`) regardless of the input size $n$. No auxiliary data structures like arrays or recursion stacks are utilized, making the space usage constant.

## 4. **Dry Run**

**Example: $n = 4$**

| Iteration | `i` | `a` | `b` | `c = a + b` | Update `a` | Update `b` | Notes |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Start | - | 0 | 1 | - | - | - | Initial state |
| $i = 2$ | 2 | 0 | 1 | 1 | 1 | 1 | $c = 0 + 1 = 1$ |
| $i = 3$ | 3 | 1 | 1 | 2 | 1 | 2 | $c = 1 + 1 = 2$ |
| $i = 4$ | 4 | 1 | 2 | 3 | 2 | 3 | $c = 1 + 2 = 3$ |

**Final Result**: `b = 3`. $F(4) = 3$. Correct.

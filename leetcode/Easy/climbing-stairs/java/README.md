# 70. Climbing Stairs

- **Platform:** leetcode
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/climbing-stairs/submissions/2066417638/)

## Solution Notes

*   Goal: Write markdown notes for the Java solution to "70. Climbing Stairs".
    *   Target Code: Iterative Dynamic Programming approach (Fibonacci-style).
    *   Required Sections:
        1.  **Brute Force Approach**
        2.  **Optimal Approach**
        3.  **Complexity Analysis**
        4.  **Dry Run**
    *   Constraints: No conversational filler, no greetings, no internal monologue, no extra sections. Only the specified four sections.

    *   *Problem context*: To reach the $n$-th step, you can come from $(n-1)$ or $(n-2)$. This is a recursive relationship: $f(n) = f(n-1) + f(n-2)$.
    *   *Brute Force*: Recursion. $f(n) \rightarrow f(n-1) + f(n-2)$. This leads to many overlapping subproblems.
    *   *Optimal Approach (the provided code)*: Iterative Dynamic Programming using space optimization. Instead of an array, use two variables (`first` and `second`) to keep track of the last two values.
    *   *Complexity*:
        *   Time: $O(n)$ because of the single loop.
        *   Space: $O(1)$ because only a constant amount of extra space is used.
    *   *Dry Run*: Let $n = 4$.
        *   `n <= 2` is false.
        *   `first = 1`, `second = 2`.
        *   Loop $i = 3$ to $4$:
            *   $i=3$: `current = 1 + 2 = 3`. `first = 2`, `second = 3`.
            *   $i=4$: `current = 2 + 3 = 5`. `first = 3`, `second = 5`.
        *   Return `second` (5).

    *   *Section 1: Brute Force Approach*
        The problem can be solved using a simple recursion where `climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)`. This approach explores all possible combinations of steps, but it results in redundant calculations of the same subproblems.

    *   *Section 2: Optimal Approach*
        The provided solution uses an iterative Dynamic Programming approach with space optimization. Since the number of ways to reach step `n` only depends on the ways to reach the two preceding steps (`n-1` and `n-2`), we don't need to store the entire DP array. Instead, we use two variables, `first` and `second`, to store the counts for the two previous steps. We iterate from step 3 up to `n`, updating these variables at each step to build up to the target.

    *   *Section 3: Complexity Analysis*
        *   **Time Complexity**: $O(n)$ — The algorithm uses a single loop that runs from 3 to $n$.
        *   **Space Complexity**: $O(1)$ — Only a constant amount of extra space is used for the variables `first`, `second`, and `current`.

    *   *Section 4: Dry Run*
        Example: `n = 5`
        1.  **Initialization**:
            - `n = 5` (greater than 2)
            - `first = 1` (ways to reach step 1)
            - `second = 2` (ways to reach step 2)
        2.  **Loop Execution** (from `i = 3` to `5`):
            - **i = 3**:
                - `current = first + second` $\rightarrow$ `1 + 2 = 3`
                - `first = second` $\rightarrow$ `2`
                - `second = current` $\rightarrow$ `3`
            - **i = 4**:
                - `current = first + second` $\rightarrow$ `2 + 3 = 5`
                - `first = second` $\rightarrow$ `3`
                - `second = current` $\rightarrow$ `5`
            - **i = 5**:
                - `current = first + second` $\rightarrow$ `3 + 5 = 8`
                - `first = second` $\rightarrow$ `5`
                - `second = current` $\rightarrow$ `8`
        3.  **Result**: Return `second` (8).

    *   Exactly the four sections? Yes.
    *   Nothing else? Yes.
    *   Detailed? Yes.
    *   Markdown? Yes.

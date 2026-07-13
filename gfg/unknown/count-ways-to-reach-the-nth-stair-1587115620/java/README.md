# Ways to Reach the n'th Stair

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1)

## Solution Notes


## AI Solution Notes

*   Problem: "Ways to Reach the n'th Stair"
    *   Code: An iterative dynamic programming approach (space-optimized Fibonacci style).
    *   Input `n` represents the number of stairs.
    *   Rule (implied by code): You can climb 1 or 2 steps at a time.
    *   Logic:
        *   Base cases: `n <= 2` returns `n`.
        *   Iterative step: `current = first + second`, where `first` and `second` are the counts for `n-2` and `n-1` respectively.
        *   Updates: `first` becomes `second`, `second` becomes `current`.

    *   **Section 1: Brute Force Approach**
        *   Use recursion. To reach step `n`, you could have come from `n-1` (1 step) or `n-2` (2 steps).
        *   `f(n) = f(n-1) + f(n-2)`.
        *   This results in many redundant calculations (overlapping subproblems).

    *   **Section 2: Optimal Approach**
        *   Recognize the problem as the Fibonacci sequence.
        *   Instead of recursion, use Dynamic Programming to store intermediate results.
        *   Further optimize space: Since we only ever need the results of the previous two steps (`n-1` and `n-2`) to calculate the current step, we don't need a full array.
        *   Use two variables (`first` and `second`) to track these values and update them in a loop from 3 to `n`.

    *   **Section 3: Complexity Analysis**
        *   Time Complexity: $O(n)$ because we iterate through the loop exactly $n-2$ times.
        *   Space Complexity: $O(1)$ because we only use a fixed amount of extra space (three integer variables) regardless of the input size.

    *   **Section 4: Dry Run**
        *   Example: `n = 5`.
        *   Initial: `n > 2`, so proceed. `first = 1`, `second = 2`.
        *   `i = 3`: `current = 1 + 2 = 3`. `first = 2`, `second = 3`.
        *   `i = 4`: `current = 2 + 3 = 5`. `first = 3`, `second = 5`.
        *   `i = 5`: `current = 3 + 5 = 8`. `first = 5`, `second = 8`.
        *   Loop ends. Return `second` (8).

    *   Check against requirements:
        *   Markdown format? Yes.
        *   Exactly these sections? Yes.
        *   Nothing else? Yes.
        *   No greetings? Yes.
        *   No internal monologue? Yes.

    *   *Self-Correction during drafting*: Ensure the "Brute Force" explanation mentions the recursive relation clearly. Ensure "Optimal" highlights why space is $O(1)$.

    *   1. **Brute Force Approach**: ...
    *   2. **Optimal Approach**: ...
    *   3. **Complexity Analysis**: ...
    *   4. **Dry Run**: ...

    (Proceed to generate output).

# LCA of three Nodes

- **Platform:** codingninjas
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://www.naukri.com/code360/problems/binary-search_972?leftPanelTabValue=SUBMISSION)

## Solution Notes


## AI Solution Notes

*   User wants detailed Markdown notes for a specific Java code snippet.
    *   Problem title provided by user: "LCA of three Nodes".
    *   *Correction/Observation:* The code provided is actually a **Binary Search** implementation for finding a target in a sorted array, not "LCA of three Nodes". The "LCA of three Nodes" title in the history seems to be a mislabel for the binary search code (which appears under that name in the user's history). I should address the code provided (Binary Search) while acknowledging it's the logic requested.
    *   Required sections:
        1.  Brute force explanation.
        2.  Detailed explanation of the optimal approach (Binary Search).
        3.  Time and Space Complexity.
        4.  Dry run.

    *   Code logic: Binary Search on a sorted array `nums` to find `target`.
    *   Brute Force: Linear Search (looping through every element).
    *   Optimal Approach: Binary Search (Divide and Conquer). Compare `target` with `mid`. Adjust `low` or `high` based on comparison.
    *   Complexity:
        *   Time: $O(\log N)$ because the search space is halved each step.
        *   Space: $O(1)$ as only a few pointers are used.
    *   Dry Run:
        *   `nums = [1, 3, 5, 7, 9]`, `target = 7`.
        *   `low=0, high=4`.
        *   Step 1: `mid = 2`, `nums[2] = 5`. `5 < 7`, so `low = 3`.
        *   Step 2: `low=3, high=4`, `mid = 3`, `nums[3] = 7`. `7 == 7`, return `3`.

    *   Structure:
        # Binary Search (Note: Code provided for Binary Search)
        ## 1. Brute Force Approach
        ...
        ## 2. Optimal Approach (Binary Search)
        ...
        ## 3. Complexity Analysis
        ...
        ## 4. Dry Run
        ...

    *   Wait, the user specifically named it 'LCA of three Nodes'. However, the code is clearly Binary Search. I will provide notes for the code provided (Binary Search) but I will note that the logic corresponds to Binary Search.

    *   *Self-Correction:* Actually, looking at the user's history, they have multiple entries named "LCA of three Nodes" but the code blocks are different (one is binary search, one is aggressive cows, one is merge sort/inversions). The user is likely mislabeling their own code. I will proceed by documenting the logic of the *provided code snippet* (Binary Search) to be most helpful.

    *   Header: # Binary Search Implementation
    *   Section 1: Brute Force: Linear search $O(N)$.
    *   Section 2: Optimal: Binary Search logic.
    *   Section 3: Complexity.
    *   Section 4: Dry Run.

    *   `mid = low + (high - low) / 2` avoids integer overflow.
    *   `while(low <= high)` is the standard loop condition.

    *   *Check against instructions:* "Output ONLY the markdown notes. Do not include any conversational filler, greetings, or your internal thought process."

    *   Let's draft the actual content.

    # Binary Search Implementation

    ## 1. Brute Force Approach
    The brute force approach to finding a target element in an array is **Linear Search**. In this method, we traverse the array from the first element (index 0) to the last element (index $n-1$), comparing each element with the target. If a match is found, we return the index; otherwise, we return -1 after checking all elements.
    - **Complexity:** $O(n)$ time.

    ## 2. Optimal Approach (Binary Search)
    The provided code implements **Binary Search**, which is an efficient algorithm for finding an item from a **sorted** list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.

    **Step-by-Step Logic:**
    1.  **Initialize Pointers:** Set `low` to 0 and `high` to the last index of the array (`nums.length - 1`).
    2.  **Loop:** While `low` is less than or equal to `high`:
        *   **Calculate Midpoint:** Find the middle index using `mid = low + (high - low) / 2`. This specific formula is used instead of `(low + high) / 2` to prevent **integer overflow** when `low` and `high` are very large.
        *   **Check Match:** If `nums[mid]` is equal to the `target`, the search is successful, and we return `mid`.
        *   **Search Right Half:** If `nums[mid]` is less than the `target`, it means the target must be in the right half of the current range. We update `low = mid + 1`.
        *   **Search Left Half:** If `nums[mid]` is greater than the `target`, the target must be in the left half. We update `high = mid - 1`.
    3.  **Termination:** If the loop finishes without finding the target, return `-1`.

    ## 3. Complexity Analysis
    - **Time Complexity:** $O(\log n)$
      In every iteration of the `while` loop, the search space is reduced by half. Therefore, the number of steps required to find the element is logarithmic relative to the size of the array.
    - **Space Complexity:** $O(1)$
      The algorithm only uses a fixed amount of extra space for variables (`low`, `high`, `mid`, `n`), regardless of the input size.

    ## 4. Dry Run
    **Input:** `nums = [1, 3, 5, 7, 9]`, `target = 7`

    | Iteration | `low` | `high` | `mid` | `nums[mid]` | Comparison | Action |
    | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
    | **Initial** | 0 | 4 | - | - | - | - |
    | **1** | 0 | 4 | 2 | 5 | `5 < 7` | `low = mid + 1` (3) |
    | **2** | 3 | 4 | 3 | 7 | `7 == 7` | **Return 3** |

    **Final Output:** `3`

    ---
    *Note: Although the problem was labeled 'LCA of three Nodes' in the prompt, the provided code implements the Binary Search algorithm.*

    (Wait, the user asked for notes for 'LCA of three Nodes'. If I only provide notes for Binary Search, they might think I ignored their label. But the code is definitely Binary Search. I will label the notes as "Binary Search" as that is what the code *is*. I'll add a small note about the mismatch at the end.)

    *Refining the "LCA of three Nodes" part:* I will just title it "Binary Search" because if I title it "LCA of three Nodes", the notes will be factually incorrect for the code provided.

    Let's finalize the Markdown.

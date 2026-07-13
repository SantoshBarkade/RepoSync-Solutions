# LCA of three Nodes

- **Platform:** codingninjas
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://www.naukri.com/code360/problems/count-inversions_615?leftPanelTabValue=SUBMISSION)

## Solution Notes


## AI Solution Notes

# LCA of three Nodes

**Note: The provided code is actually an implementation of the Inversion Count problem using Merge Sort, not the LCA of three Nodes problem.**

## 1. **Brute Force Approach**

A brute force approach to find the inversion count of an array would involve nested loops to compare every possible pair of $(i, j)$ where $0 \le i < j < n$. For every such pair, if $arr[i] > arr[j]$, it is considered an inversion. This approach takes $O(n^2)$ time.

## 2. **Optimal Approach**

The provided implementation uses the **Divide and Conquer** strategy via the **Merge Sort** algorithm. The core idea is that during the merge step of the sorting process, we can count the number of pairs that violate the ascending order.

### Algorithm Breakdown:

1.  **Divide**: The array is recursively split into two halves until the base case (a single element or empty array) is reached ($low \ge high$).
2.  **Conquer**: Each half is sorted independently through recursive calls.
3.  **Combine (Merge Step)**: This is where the actual counting happens. When merging two sorted sub-arrays (left side from `low` to `mid` and right side from `mid+1` to `high`): 
    *   We maintain two pointers, `left` and `right`, starting at the beginning of each sub-array.
    *   If `arr[left] <= arr[right]`, the element in the left sub-array is in its correct relative order. We add it to the temporary list and increment `left`.
    *   If `arr[left] > arr[right]`, it means `arr[right]` is smaller than `arr[left]`. Since the left sub-array is already sorted, if `arr[right]` is smaller than `arr[left]`, it must also be smaller than all remaining elements in the left sub-array (`arr[left], arr[left+1], ..., arr[mid]`). 
    *   **Counting Rule**: The number of inversions contributed by `arr[right]` is exactly `(mid - left + 1)`. We add this value to our total count.
4.  **Update**: After the merge, the temporary list `res` is copied back into the original array `arr` to maintain the sorted property for the next level of the recursion.

## 3. **Complexity Analysis**

### Time Complexity
*   **Merge Sort**: The recursion tree has a\log N$ depth. At each level of the recursion, the merge process iterates through the total number of elements in that segment, which is $O(N)$. 
*   **Overall Time Complexity**: $O(N \log N)$, where $N$ is the size of the array.

### Space Complexity
*   **Auxiliary Space**: The algorithm uses an `ArrayList<Long>` named `res` to store elements during the merge process. In the worst case, the space used at each level of the merge is proportional to the size of the sub-arrays being merged.
*   **Overall Space Complexity**: $O(N)$ due to the temporary storage required for the merge step.


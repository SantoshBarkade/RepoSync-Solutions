# LCA of three Nodes

- **Platform:** codingninjas
- **Difficulty:** Easy
- **Tags:** 
- **URL:** [Link](https://www.naukri.com/code360/problems/largest-rectangle-in-a-histogram_1058184?leftPanelTabValue=SUBMISSION)

## Solution Notes

# LCA of three Nodes

## 1. **Brute Force Approach**
To find the largest rectangle in a histogram, a brute force approach would involve checking every possible pair of bars in the histogram. For each pair of (start, end), you would determine the minimum height among all bars between those indices. The area for that rectangle would be calculated as `(end - start + 1) * min_height`. This would result in a massive number of redundant calculations, specifically repeatedly finding the minimum height in sub-ranges.

## 2. **Optimal Approach**
The provided solution uses a **Monotonic Stack** approach. The goal is to largest rectangle is limited by the shortest bar within its width. To calculate the area for every bar, we need to find the boundaries: the first bar to the left that is shorter than the current bar, and the first bar to the right that is shorter than the current bar.

### Key Mechanism: Monotonic Increasing Stack
1. **Stack Contents**: The stack stores indices of the histogram bars. The stack maintains a property where the heights of the bars at the stored indices are in non-decreasing order.
2. **The Trigger**: When we encounter a current height `currHeight` that is *smaller* than the height of the bar at the index stored at the top of the stack, it means the bar at `stack.peek()` has found its **Right Boundary**. The height of the bar at `stack.peek()` can no longer extend further to the right.
3. **Calculating Area**: 
   - When a bar is popped from the stack, it is treated as the **Height** of the rectangle.
   - The **Right Boundary** (`right`) is the current index `i` (the first index to the right with a smaller height).
   - The **Left Boundary** (`left`) is the new `stack.peek()` after the popping operation (the first index to the left with a smaller height). If the stack is empty after popping, the left boundary is conceptually `-1`.
   - **Width calculation**: `width = right - left - 1`.
   - **Area calculation**: `area = width * height`.

### Handling the End of the Array
To ensure all bars remaining in the stack are processed at the end of the loop, a virtual bar of height `0` is added at index `n` (the case `i == n`). This forces the stack to pop all remaining elements because `0` will always be less than any height in the histogram.

## 3. **Complexity Analysis**

### Time Complexity
- **O(N)**: Although there is a `while` loop inside a `for` loop, every single index is pushed onto the stack exactly once and popped from the stack exactly once. This results in a linear relationship between the number of bars and the operations performed.

### Space Complexity
- **O(N)**: In the worst-case scenario (e.g., if the heights are in strictly increasing order), all indices will be pushed onto the stack before any are popped, requiring linear space proportional to the size of the input array.


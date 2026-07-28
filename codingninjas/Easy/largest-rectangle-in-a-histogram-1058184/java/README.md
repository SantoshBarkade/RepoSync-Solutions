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



## AI Solution Notes

# LCA of three Nodes

## 1. **Brute Force Approach**
To find the Largest Rectangle in a Histogram, a brute force approach would involve iterating through every possible pair of bars in the histogram. For each pair (i, j), you would find the minimum height among all bars from index i to j. The area for that rectangle would then be calculated as `minHeight * (j - i + 1)`. By checking all possible sub-segments, the complexity becomes significantly higher than the optimal approach.

## 2. **Optimal Approach**
The provided solution implements the **Monotonic Increasing Stack** algorithm. The goal is is to determine, for every bar, the nearest bar to its left and the right that is strictly shorter than itself. These two boundaries define the maximum width for which the current bar can serve as the shortest bar in a rectangle.

### Algorithm Steps:
1. **Monotonic Stack Maintenance**: We iterate through the histogram bars. The stack stores indices of the bars in non-decreasing order of their heights. 
2. **The Trigger Condition**: When we encounter a bar (`currHeight`) that is shorter than the bar at the top of the stack (`heights.get(stack.peek())`), it means we have found the right boundary for the bar at the top of the stack. 
3. **Calculating Area**: 
    - We pop the top index from the stack. This index represents the bar whose area we are currently calculating.
    - The popped bar's height is the `height`.
    - The **right boundary** is the current index `i` (the first bar to the right that is shorter).
    - The **left boundary** is the new top of the stack after the popping (the first bar to the left that is shorter). If the stack is empty, the left boundary is `-1`.
    - The `width` is calculated as `right - left - 1`.
    - `area = width * height`.
4. **Sentinel Value**: The loop runs up to `i == n`. When `i == n`, `currHeight` is set to `0`. This acts as a virtual bar of height zero at the end of the histogram, which forces the stack to clear and ensures all remaining bars in the stack are processed and their areas calculated.

## 3. **Complexity Analysis**

### Time Complexity
- **O(N)**: Each index is pushed onto the stack exactly once and popped from the stack exactly once. Even though there is a nested `while` loop, the total number of push and pop operations is linear relative to the number of bars `N`.

### Space Complexity
- **O(N)**: In the worst case (eg., a strictly increasing sequence of heights), the stack will store all `N` indices.


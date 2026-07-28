# Accepted Java Solution :

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/count-reverse-pairs/1)

## Solution Notes

# **Reverse Pairs Analysis**

## 1. **Brute Force Approach**

A naive solution would involve using two nested loops to iterate through every possible pair $(i, j)$ in the array where $i < j$. For each pair, we check the condition $arr[i] > 2 	imes arr[j]$. If the condition is met, we increment a counter. While straightforward to implement, this approach is highly inefficient for large datasets because it checks every single pair.

## 2. **Optimal Approach**

This solution utilizes a modified **Merge Sort** algorithm to count the reverse pairs in $O(N 	imes 	ext{log } N)$ time. The core idea is that Merge Sort naturally divides the array into sorted subarrays. By counting the pairs during the 


## AI Solution Notes

## 1. **Brute Force Approach**

A simple brute force approach would involve using two nested loops to iterate through every possible pair ((i, j)) in the array such that 0 <&& i < j. For each pair, check if the condition `arr[i] > 2 * arr[j]` is satisfied. If it is, increment a global counter. This approach checks all &times; of combinations, leading to a highly inefficient solution for large input sizes.
\n## 2. **Optimal Approach**

This solution utilizes the **Divide and Conquer** strategy, specifically leveraging the structure of the **Merge Sort** algorithm to count reverse pairs efficiently. The core idea is to expand the scope of the problem by breaking the array into smaller sub-arrays, counting pairs within those sub-arrays, and then counting pairs that span across the two sorted halves.

### Key Components:

1. **Divide and Conquer (Merge Sort Framework)**:
The algorithm recursively divides the array into two halves until the base case (single element sub-arrays) is reached. During the merge step, it counts pairs that satisfy the condition `arr[i] > 2 * arr[j]`.

2. **Counting Pairs (`countPairs` method)**:
This is the crucial step. After the left and right sub-arrays are `arr[low...mid]` and `arr[mid+1...high]` are independently sorted, we can count the reverse pairs effectively. Because both sub-arrays are already sorted, we can use a **two-pointer approach** to find the number of pairs. For every element in the left sub-array, we iterate a pointer `right` through the right sub-array to find the maximum index `right` such that the condition `arr[i] > 2 * arr[right]` holds. Since the elements in the left sub-array are increasing, as `i` increases, the `right` pointer only needs to move forward, never backward. This results in an linear time scan for counting.

3. **Merging (`merge` method)**:
Standard merge sort merging process. After counting the pairs, the standard merge sort logic combines the two sorted sub-arrays into a single sorted array. This ensures that the subsequent recursive calls (higher levels of the recursion tree) higher up in the stack can correctly apply the ability to use two pointers in the `countPairs` function.

### Implementation Detail: Long Casting
To prevent integer overflow when calculating `2 * arr[right]`, the code uses `(long) arr[i] > 2L * arr[right]`. This is critical because if `arr[right]` is a large positive integer, multiplying it by 2 might exceed the capacity of a 32-bit signed integer.

## 3. **Complexity Analysis**

### Time Complexity:
- **Divide Phase**: The array is split into two halves at each level of the recursion, resulting in a recursion tree of depth $\log N$. At each level of the recursion tree, the total work done across all nodes is $O(N)$.
- **Counting Phase**: The `countPairs` function uses a two-pointer approach where `right` only traverses the right sub-array once per merge step, leading to $O(N)$ time. 
- **Merge Phase**: The standard merge procedure also takes $O(N)$ time.
- **Overall**: Since we perform $O(N)$ work at each of the $\log N$ levels, the total time complexity is $O(N \log N)$.

### Space Complexity:
- **Auxiliary Space**: The presence of a the temporary array `temp` used during the merging process requires $O(N)$ extra space. 
- **Recursion Stack**: The recursion depth is $O(\log N)$.
- **Total**: The overall space complexity is $O(N)$.

## 4. **Dry Run**

**Input Array**: `[4, 1, 3, 2]`

1. **Initial Call**: `mergeSort(arr, 0, 3)`
   - Sub-array 1: `[4]` and Sub-array 2: `[1, 3, 2]`
   - Recursive call `mergeSort(arr, 1, 3)` to process right half.

2. **Processing `mergeSort(arr, 1, 3)`**:
   - Sub-array 1: `[1]` and Sub-array 2: `[3, 2]`
   - Recursive call `mergeSort(arr, 2, 3)` to process right half.

3. **Processing `mergeSort(arr, 2, 3)`**:
   - Sub-array 1: `[3]` and Sub-array 2: `[2]`
   - `countPairs(3, 2)`: `3 > 2 * 2` is false. Count = 0.
   - `merge([3], [2])`: Array becomes `[2, 3]`.
   - Returns 0.

4. **Back to `mergeSort(arr, 1, 3)`** (Left: `[1]`, Right: `[2, 3]`):
   - `countPairs([1], [2, 3])`: 
     - `i=1` (val 1): `1 > 2 * 2` false. `right` stays at index 2.
     - Count = 0.
   - `merge([1], [2, 3])`: Array becomes `[1, 2, 3]`.
   - Returns 0.

5. **Back to `mergeSort(arr, 0, 3)`** (Left: `[4]`, Right: `[1, 2, 3]`):
   - `countPairs([4], [1, 2, 3])`:
     - `i=0` (val 4): 
       - `right=1` (val 1): `4 > 2 * 1` is true. `right` becomes 2.
       - `right=2` (val 2): `4 > 2 * 2` is false. `right` stays at 2.
       - Count = (2 - 1) = 1.
     - Total Count = 1.
   - `merge([4], [1, 2, 3])`: Array becomes `[1, 2, 3, 4]`.
   - Returns 1.

**Final Count: 1** (The pair is (4, 1)).

# One-Line Memory Trick

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)

## Solution Notes

# One-Line Memory Trick - Technical Documentation

## 1. **Brute Force Approach**
In a brute force approach, we would iterate through every possible pair of elements in the array using nested loops. For each pair $(i, j)$, we check if $i < j$ and $arr[i] > arr[j]$. If this condition is met, it is considered an inversion, and we increment a counter. This approach is highly inefficient for large datasets as it requires checking all $O(n^2)$ pairs.

## 2. **Optimal Approach**
The provided solution utilizes a modified **Merge Sort** algorithm to count inversions. This is an optimal approach because it leverages the divide-and-conquer paradigm to achieve sub-quadratic time complexity.

### Divide and Conquer Mechanism
1. **Divide**: The array is recursively split into two halves (left subarray and right subarray) until the base case of a single element is reached (where `low >= high`).
2. **Conquer**: Each subarray is sorted independently using the recursive `mergeSort` calls.
3. **Combine (The Core Logic)**: The `merge` function is responsible for both sorting the merged elements and counting the inversions that occur between the elements of the two sorted halves.

### Counting Inversions during Merge
The key insight lies in the `merge` step. When merging two sorted subarrays (Left: `[low...mid]` and Right: `[mid+1...high]`):
- If `arr[left] <= arr[right]`, the left element is smaller or equal. No inversion is counted here, and the element is added to the result list.
- If `arr[left] > arr[right]`, an inversion is detected. Since both subarrays are already sorted, if `arr[left]` is greater than `arr[right]`, then **all** elements from the current `left` index to the `mid` index in the left subarray must also be greater than `arr[right]`. 
- The number of inversion count for this specific `right` element is calculated as `(mid - left + 1)`. This value is is added to the total count.

### Implementation Details
- A temporary `ArrayList<Integer> res` is used to store the merged elements during the merge process.
- After the merging is process is complete, the elements are copied back from the `res` list into the original array segment `arr[low...high]` to ensure the array remains sorted for subsequent levels of recursion.

## 3. **Complexity Analysis**

### Time Complexity
- **Best, Average, and Worst Case**: $O(n 	ext{ log } n)$. The algorithm follows the structure of a single Merge Sort. The recurrence relation is $T(n) = 2T(n/2) + O(n)$, which according to the Master Theorem, results in $O(n 	ext{ log } n)$. The additional constant time work for adding to the inversion count does not change this complexity.

### Space Complexity
- **Auxiliary Space**: $O(n)$. The algorithm requires extra space to store the elements in the `ArrayList<Integer> res` during the merge phase. Additionally, there is $O(	ext{log } n)$ stack space used due to the recursion depth, but the $O(n)$ auxiliary space for the temporary array dominates the complexity.

## 4. **Dry Run**

**Input Array**: `[8, 4, 2, 1]`

1. **Initial Call**: `mergeSort(arr, 0, 3)`
   - Splits into `mergeSort(0, 1)` and `mergeSort(2, 3)`

2. **Level 1 - Left Side**: `mergeSort(0, 1)` (Subarray `[8, 4]`)
   - Splits into `mergeSort(0, 0)` and `mergeSort(1, 1)` (Base cases: returns 0)
   - **Merge `[8]` and `[4]`**:
     - `left=0, right=2, mid=0, high=1`
     - `arr[0] (8) > arr[2] (4)`? No, `right` is index 2 in global context, but in this sub-call, `right` starts at `mid+1=1`.
     - `left=0, right=1`
     - `8 > 4`: Inversion! `cnt += (0 - 0 + 1) = 1`. `res=[4]`, `right` moves to 2.
     - Remaining `left`: `res=[4, 8]`, `left` moves to 2.
     - `arr` becomes `[4, 8, 2, 1]`
     - **Returns `cnt = 1`**

3. **Level 1 - Right Side**: `mergeSort(2, 3)` (Subarray `[2, 1]`)
   - Splits into `mergeSort(2, 2)` and `mergeSort(3, 3)` (Base cases: returns 0)
   - **Merge `[8, 4]` becomes `[4, 8]` and `[2, 1]`**:
     - `left=2, right=3, mid=2, high=3`
     - Subarray is `[2, 1]`
     - `2 > 1`: Inversion! `cnt += (2 - 2 + 1) = 1`. `res=[1]`, `right` moves to 4.
     - Remaining `left`: `res=[1, 2]`, `left` moves to 3.
     - `arr` becomes `[4, 8, 1, 2]` (local view of this segment)
     - **Returns `cnt = 1`**

4. **Level 2 - Final Merge**: `merge(arr, 0, 1, 3)` (Subarrays `[4, 8]` and `[1, 2]`)
n   - `left=0 (val 4), mid=1, right=2 (val 1), high=3`
   - **Compare 4 and 1**: `4 > 1`. Inversion! `cnt += (1 - 0 + 1) = 2`. `res=[1]`, `right` moves to 3.
   - **Compare 4 and 2**: `4 > 2`. Inversion! `cnt += (1 - 0 + 1) = 2`. `res=[1, 2]`, `right` moves to 4.
   - **Compare 2 and 4**: `left` is not exhausted, `right` is exhausted. Add remaining `left`: `res=[1, 2, 4, 8]`. `left` moves to 4.
   - **Total `cnt` in this merge**: $2 + 2 = 4$

5. **Final Result**: Total Inversions = $1 (	ext{from left}) + 1 (	ext{from right}) + 4 (	ext{from final merge}) = 6$. 
- Wait, let's re-check the logic. Input `[8, 4, 2, 1]`. Pairs: (8,4), (8,2), (8,1), (4,2), (4,1), (2,1). Total is 6. Correct.


## AI Solution Notes

# One-Line Memory Trick - Inversion Count

## 1. **Brute Force Approach**
To find the number of inversions in an array, a brute force approach would involve using two nested loops. The outer loop iterates through each element $i$ from $0$ to $n-1$, and the inner loop iterates through each element $j$ from $i+1$ to $n-1$. For every pair $(i, j)$, if $arr[i] > arr[j]$, an inversion is counted. This approach is straightforward but inefficient for large datasets due to its high time complexity.

## 2. **Optimal Approach**
The optimal approach utilizes the **Divide and Conquer** strategy, specifically a modified version of the **Merge Sort** algorithm. The core idea is to count inversions while sorting the array. 

### Divide Phase
1. The array is recursively divided into two halves until each sub-array contains only one element. A single element is inherently sorted and has zero inversions.

### Conquer and Merge Phase
2. During the merge step, two sorted sub-arrays (left part and right part) are merged into a single sorted array. This is where the inversion count is calculated:
    - If $arr[left] \leq arr[right]$, there is no inversion between the current elements of the left and right sub-arrays. The element from the left sub-array is added to the result list.
    - If $arr[left] > arr[right]$, then since the left sub-array is also sorted, every remaining element in the left sub-array from the index `left` to `mid` is greater than `arr[right]`. Thus, the number of inversions contributed by `arr[right]` is calculated as `(mid - left + 1)`. This count is added to the total inversion count.

### Reassembling
3. After the merge step, the elements are merged into a temporary list and then copied back into the original array to maintain the sorted order for higher-level recursive calls.

## 3. **Complexity Analysis**

### Time Complexity
- **Best, Average, and Worst Case**: $O(N \log N)$. The array is divided into $\log N$ levels of recursion, and at each level, the work done in thes `merge` function (merging two sub-arrays) is proportional to $N$. This follows the standard time complexity of Merge Sort.

### Space Complexity
- **Space Complexity**: $O(N)$. An auxiliary list (or array) `res` is used during the merge step to store the elements temporarily. Additionally, the recursive stack space used by the method calls is $O(\log N)$, but the dominant factor is $O(N)$ due to the temporary storage.

## 4. **Dry Run**

**Input Array**: `[8, 4, 2, 1]`

1. **Initial Call**: `mergeSort(arr, 0, 3)`
   - Splits into `mergeSort(arr, 0, 1)` and `mergeSort(arr, 2, 3)`.

2. ****Sub-problem 1**: `mergeSort(arr, 0, 1)` ([8, 4])
   - Splits into `mergeSort(arr, 0, 0)` ([8]) and `mergeSort(arr, 1, 1)` ([4]).
   - **Merge([8], [4])**:
     - $left=0, right=1$. $arr[0]=8, arr[1]=4$. 
     - $8 > 4$: `cnt += (mid - left + 1)` $\rightarrow$ `cnt += (0 - 0 + 1) = 1`. `res = [4]`. `right++`.
     - $left=0$. $arr[0]=8$. `res = [4, 8]`. `left++`.
     - **Array state after merge**: `[4, 8, 2, 1]`
     - **Inversion count**: 1.

3. ****Sub-problem 2**: `mergeSort(arr, 2, 3)` ([2, 1])
   - Splits into `mergeSort(arr, 2, 2)` ([2]) and `mergeSort(arr, 3, 3)` ([1]).
   - **Merge([2], [1])**:
     - $left=2, right=3$. $arr[2]=2, arr[3]=1$. 
     - $2 > 1$: `cnt += (mid - left + 1)` $\rightarrow$ `cnt += (2 - 2 + 1) = 1`. `res = [1]`. `right++`.
     - $left=2$. $arr[2]=2$. `res = [1, 2]`. `left++`.
     - **Array state after merge**: `[4, 8, 1, 2]`
     - **Inversion count**: 1.

4. **Final Merge (Merge [4, 8] and [1, 2])**:
   - $left=0, right=2$. $arr[0]=4, arr[2]=1$.
   - $4 > 1$: `cnt += (mid - left + 1)` $ightarrow$ `cnt += (1 - 0 + 1) = 2`. `res = [1]`. `right++`.
   - $left=0, right=2$. $arr[0]=4, arr[3]=2$.
   - $4 > 2$: `cnt += (mid - left + 1)` $ightarrow$ `cnt += (1 - 0 + 1) = 2`. `res = [1, 2]`. `right++`.
   - $left=0, right=2$. $arr[0]=4, arr[1]=8$. 
   - $4 \leq 8$: `res = [1, 2, 4]`. `left++`.
   - $left=1, right=2$. $arr[1]=8, (no	ext{ more right elements})$. 
   - **Loop ends**. Remaining elements from left: `res = [1, 2, 4, 8]`. `left++`.
   - **Total Inversions**: $1 (from	ext{ sub-problem 1}) + 1 (from	ext{ sub-problem 2}) + 3 (from	ext{ final merge merge}) = 5$. Wait, let's re-verify the inversion count manually: (8,4), (8,2), (8,1), (4,2), (4,1), (2,1) $ightarrow$ 6 inversions. 
   - Let's re-verify the logic: 
     - (8,4) is 1.
     - (2,1) is 1.
     - Merge([4,8], [1,2]): 
       - 4 > 1: (4,1) and (8,1) are 2.
       - 4 > 2: (4,2) and (8,2) are 2.
       - Total: 1 + 1 + 2 + 2 = 6. 

   - **Wait, my calculation error in dry run step 4**: $1+1+2+2 = 6$. Correct.
   - **Total Inversions**: 6.

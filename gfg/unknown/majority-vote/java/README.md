# Problem Solved Successfully

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/majority-vote/1)

## Solution Notes

# **Problem: Find Majority Elements (> n/3)**

## 1. **Brute Force Approach**
To find elements that appear more than `n/3` times in an array, a brute force approach would involve using a nested loop structure. For every element in the array, you would iterate through the entire array again to count its occurrences. If the count exceeds `n/3`, you add it to a result list. To avoid duplicates in the result, you might use a set or check if the element has already been added. This approach is inefficient for large datasets due to its quadratic time complexity.

## 2. **Optimal Approach**
The provided solution implements the **Boyer-Moore Voting Algorithm**, specifically the generalized version for finding elements appearing more than `n/k` times (in this case, `k=3`). 

### **Phase 1: Finding Potential Candidates**
In any array of size `n`, there can be at most two elements that appear more than `n/3` times. The algorithm maintains two candidates (`el1`, `el2`) and two counters (`cnt1`, `cnt2`). 

1. **Initialization**: We start with two candidates set to `Integer.MIN_VALUE` and counters at `0`.
2. **Iterating through the array**:
   - **Case 1**: If a counter is `0` and the current number is not equal to the other candidate, we assign the current number as the new candidate for that counter.
   - **Case 2**: If the current number matches `el1`, we increment `cnt1`.
   -**Case 3**: If the current number matches `el2`, we increment `cnt2`.
   - **Case 4**: If the current number matches neither and both counters are non-zero, we decrement both counters. This effectively 'cancels out' three distinct elements.

### **Phase 2: Verification**
Since the Boyer-Moore algorithm only identifies potential candidates, we must perform a second pass to verify if these candidates actually appear more than `n/3` times. 

1. **Resetting Counters**: We reset `cnt1` and `cnt2` to `0`.
2. **Counting Occurrences**: We iterate through the array one more time. For every occurrence of `el1` or `el2`, we increment the respective counter.
3. **Threshold Check**: We calculate the threshold `min = n/3 + 1`. If a candidate's count is greater than or equal to this threshold, it is added to the result list.
4. **Final Step**: The result list is sorted to ensure the output is in ascending order as required.

## 3. **Complexity Analysis**

### **Time Complexity**
- **First Pass**: $O(n)$ to find the potential candidates.
- **Second Pass**: $O(n)$ to verify the counts of the candidates.
- **Sorting**: $O(1)$ because the result list can contain at most 2 elements.
- **Total Time Complexity**: $O(n)$, where $n$ is the length of the array.

### **Space Complexity**
- The algorithm uses a constant amount of extra space for variables (`cnt1`, `cnt2`, `el1`, `el2`, `min`, etc.).
- **Total Space Complexity**: $O(1)$, excluding the space used for the output list.

## 4. **Dry Run**

**Input Array**: `[3, 2, 3, 1, 2, 2, 3]`
**n** = 7, **min threshold** = $7/3 + 1 = 3$

| Step | num | el1 | cnt1 | el2 | cnt2 | Action |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Init | - | MIN | 0 | MIN | 0 | Initialize |
| 1 | 3 | 3 | 1 | MIN | 0 | `cnt1` is 0, set `el1=3` |
| 2 | 2 | 3 | 1 | 2 | 1 | `cnt2` is 0, set `el2=2` |
| 3 | 3 | 3 | 2 | 2 | 1 | `el1 == num`, increment `cnt1` |
| 4 | 1 | 3 | 1 | 2 | 0 | Neither match, decrement both |
| 5 | 2 | 3 | 1 | 2 | 1 | `el2 == num`, increment `cnt2` |
| 6 | 2 | 3 | 1 | 2 | 2 | `el2 == num`, increment `cnt2` |
| 7 | 3 | 3 | 2 | 2 | 2 | `el1 == num`, increment `cnt1` |

**Verification Pass**:
- Count `3`: appears 3 times. $3 	ext{ (count)} 
less 3 	ext{ (min)}$? No, $3 	ext{ (count)} 	ext{ is } 	ext{valid}$. (Note: $3 	ext{ (count)} 	ext{ is } 	ext{valid}$ since $3 	ext{ (count)} 	ext{ is } 	ext{threshold}$. It is $	ext{not } < 3$. Wait, let's re-evaluate.) 
- Re-check Logic: $n=7$, $n/3 = 2.33$. Threshold is elements appearing $	ext{more than } 2$. So $3$ is valid. 
- Let's check threshold logic: `min = n/3 + 1` $ightarrow 7/3 + 1 = 2 + 1 = 3$. Since count (3) $	ext{is } 	ext{at least } 3$, it is valid.
- Count `2`: appears 3 times. $3 	ext{ (count)} 	ext{is valid}$.

**Final Result**: `[2, 3]`

# Unknown Problem

- **Platform:** codingninjas
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.naukri.com/code360/problems/sum-of-subarray-minimums_8365431?leftPanelTabValue=SUBMISSION)

## Solution Notes

# Sum of Subarray Minimums

## 1. **Brute Force Approach**

The brute force approach involves iterating through every possible subarray of the given array. For each subarray, find its minimum element, and then add this minimum to a running total. 

- Iterate through all possible starting indices `i` from `0` to `n-1`.
- Iterate through all possible ending indices `j` from `i` to `n-1`.
- Find the minimum element in the subarray `arr[i...j]`.
- This results in a time complexity of $O(n^2)$ if we find the minimum while expanding the subarray, or $O(n^3)$ if we perform a separate loop to find the minimum.

## 2. **Optimal Approach**

The optimal approach uses the **Monotonic Stack** technique to solve the problem in linear time. The core idea is to determine, for each element `arr[i]`, how many subarrays exist where `arr[i]` is the minimum element. 

Instead of finding all subarrays, we calculate the contribution of each element to the total sum. If an element `arr[i]` is the minimum for a range of indices from `L` to `R` (where `L` is the first index to the left with a value smaller than `arr[i]` and `R` is the first index to the right with a value smaller than or equal to `arr[i]`), then the number of subarrays where `arr[i]` is the minimum is calculated as `(i - L) * (R - i)`.

### Key Steps:

1. **Find Previous Smaller Element (PSE):** 
   We use a monotonic stack to find the index of the nearest element to the left that is strictly smaller than `arr[i]`. Let's call this distance `left[i]`. This represents the number of ways to choose a starting point for the subarray such that `arr[i]` remains the minimum.

2. **Find Next Smaller or Equal Element (NSE):** 
   We use a monotonic stack to find the index of the nearest element to to the right that is smaller than or equal to `arr[i]`. We use 

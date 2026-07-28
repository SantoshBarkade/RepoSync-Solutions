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

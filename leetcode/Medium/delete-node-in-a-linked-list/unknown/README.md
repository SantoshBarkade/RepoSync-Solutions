# 237. Delete Node in a Linked List

- **Platform:** leetcode
- **Difficulty:** Medium
- **Tags:** 
- **URL:** [Link](https://leetcode.com/problems/delete-node-in-a-linked-list/description/)

## Solution Notes

# 237. Delete Node in a Linked List

## 1. **Brute Force Approach**
In a typical singly linked list deletion, one would need access to the `head` of the list to traverse from the start and find the predecessor (the node immediately preceding the target node) to update its `next` pointer. However, this problem specifically provides only the access to the node that needs to be deleted, without access to the head. A brute force approach in this context would imply searching for the predecessor if the head were provided, which is impossible under the given constraints.

## 2. **Optimal Approach**
The provided solution uses a clever 

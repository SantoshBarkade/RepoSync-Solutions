# Stack using Linked List

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1)

## Solution Notes

# Stack Implementation using Linked List

## 1. **Brute Force Approach**

In a brute force scenario, one might attempt to use a dynamic array or an `ArrayList` to implement a stack. While this works, arrays have fixed sizes (unless using dynamic resizing like `ArrayList`), and resizing operations can occasionally lead to $O(N)$ time complexity for a single push operation when the capacity is reached. A simpler but less efficient approach might involve using a standard collection without managing the underlying pointers, which lacks the granular control required for a low-level understanding of data structures.

## 2. **Optimal Approach**

To achieve true $O(1)$ performance for all fundamental stack operations without the overhead of array resizing, a **Singly Linked List** is the optimal approach. 

### Core Logic
In this implementation, the stack follows the **Last-In-First-Out (LIFO)** principle. Instead of adding elements to the end of the list (which would require traversing the entire list), we treat the **head** of the linked list as the **top** of the stack. This ensures that every operation occurs at the beginning of the list, allowing for constant time complexity.

### Operations Breakdown
- **`push(int x)`**: A new node is created with the value `x`. The `next` pointer of this new node is set to point to the current `top`. Then, the `top` pointer is updated to point to this new node. This effectively inserts the node at the head of the linked list.
- **`pop()`**: The stack checks if it is empty. If not, it moves the `top` pointer to `top.next`. This effectively removes the first node from the list, as the garbage collector in Java will handle the deallocation of the unreferenced node.
- **`peek()`**: This operation simply returns the data stored in the node currently pointed to by `top`. If the stack is empty (`top == null`), it returns `-1` as per the requirement.
- **`isEmpty()`**: Checks if the `top` pointer is `null`. If the `top` is null, there are no nodes in the stack.
- **`size()`**: Returns a pre-maintained `count` variable that tracks the number of elements currently in the stack, providing $O(1)$ access to the size.

## 3. **Complexity Analysis**

### Time Complexity
- **`push(int x)`**: $O(1)$ - Adding a node at the head of the linked list involves a constant number of pointer updates.
- **`pop()`**: $O(1)$ - Removing the top node involves moving the pointer to the next node, regardless of the size of the stack.
- **`peek()`**: $O(1)$ - Accessing the data of the node at the `top` pointer is a constant time operation.
- **`isEmpty()`**: $O(1)$ - A simple null check on the `top` pointer.
- **`size()`**: $O(1)$ - Returning the `count` integer is a constant time operation.

### Space Complexity
- **Overall Space Complexity**: $O(N)$, where $N$ is the number of elements currently stored in the stack. Each element requires the introduction of a new `Node` object in memory, which stores both the integer data and a pointer to the next node.


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



## AI Solution Notes

# Stack Implementation using Linked List

## 1. **Brute Force Approach**
One could implement a stack using a dynamic array (like `ArrayList` in Java). While this allows for $O(1)$ amortized push operations, resizing the array when it reaches capacity can lead to $O(n)$ latency for certain insertions. Alternatively, one could use a fixed-size array, which lacks the flexibility of dynamic memory allocation and may lead to stack overflow if the capacity is exceeded.

## 2. **Optimal Approach**
The provided solution implements a stack using a **Singly Linked List**. This is the most efficient way to implement a stack when the size is not known in advance, as it avoids the array resizing overhead. In this implementation, the `top` pointer always points to the head of the linked list, representing the top of the stack.

### Key Components:
* **`Node` Class**: Each node contains an integer `data` and a pointer `next` to the next node in the stack. This structure allows for continuous memory allocation as needed.
* **`top` Pointer**: A reference to the most recently added node. All stack operations are occur at this pointer.
* **`count` Variable**: An integer that keeps track of the number of elements currently in the stack, allowing for $O(1)$ retrieval of the stack size.

### Operations:
* **`push(int x)`**: 
    1. Create a new node with value `x`.
    2. Set the new node's `next` pointer to the current `top`.
    3. Update `top` to the new node. This makes the new node the new head of the list.
    4. Increment `count`.
* **`pop()`**: 
    1. Check if the stack is empty using `isEmpty()`.
    2. If not empty, move the `top` pointer to `top.next`.
    3. This effectively removes the head node from the list, and the Java Garbage Collector will reclaim the memory of the unreferenced node.
    4. Decrement `count`.
* **`peek()`**: 
    1. Check if the stack is empty.
    2. If empty, return `-1` (as per requirement).
    3. Otherwise, return `top.data`.
* **`isEmpty()`**: 
    1. Returns `true` if `top == null`, indicating there are no nodes in the list.
* **`size()`**: 
    1. Returns the current value of `count`.

## 3. **Complexity Analysis**

### Time Complexity:
* **`push(int x)`**: $O(1)$. Adding a node to the head of a linked list is a constant time operation.
* **`pop()`**: $O(1)$. Moving the head pointer to the next node is a constant time operation.
* **`peek()`**: $O(1)$. Accessing the data at the current `top` node is $O(1)$. 
* **`isEmpty()`**: $O(1)$. Comparing a null reference to null is $O(1)$. 
* **`size()`**: $O(1)$. Accessing the pre-maintained `count` variable is $O(1)$. 

### Space Complexity:
* **Total Space**: $O(n)$, where $n$ is the number of elements stored in the stack, as each element requires a node in memory.
* **Auxiliary Space**: $O(1)$ per operation, as no extra space proportional to the input size is used during the execution of a single method call (excluding the memory required for the node itself).

## 4. **Dry Run**

**Scenario**: Push(10), Push(20), Peek(), Pop(), Pop(), Size()

1.  **Initialization**: `top = null`, `count = 0`.
2.  **`push(10)`**:
    * New Node(10) created.
    * `newNode.next` = `null` (current `top`).
    * `top` = `Node(10)`.
    * `count = 1`.
3.  **`push(20)`**:
    * New Node(20) created.
    * `4.  **`peek()`**:
    * Returns `top.data` which is `20`.
    * Result: `20`.
4.  **`pop()`**:
    * `top` is not null. 
    * `top` = `top.next` (which is `Node(10)`).
    * `top` = `Node(10)`.
    * `count = 1`.
5.  **`pop()`**:
    * `top` is not null.
    * `top` = `top.next` (which is `null`).
    * `top = null`.
    * `count = 0`.
6.  **`6.  **`size()`**:
    * Returns `count` which is `0`.
    * Result: `0`.


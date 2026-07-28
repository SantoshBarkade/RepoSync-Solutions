# BEST C++ SOLUTION

- **Platform:** gfg
- **Difficulty:** unknown
- **Tags:** 
- **URL:** [Link](https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1)

## Solution Notes

## 1. **Brute Force Approach**

In the context of implementing a Queue using a Linked List, a brute force approach might involve using a fixed-size array to store elements. However, this is inefficient because arrays have a fixed capacity. If the queue grows beyond the array size, it would require resizing (copying all elements to a new, larger array), which is $O(n)$ time complexity. Additionally, if elements are removed from the front, the indices must be shifted, leading to $O(n)$ time for each `dequeue` operation unless a circular array is implementation is used.

## 2. **Optimal Approach**

The provided code implements a Queue data structure using a **Singly Linked List**. This is the optimal way to implement a Queue when the size is not known beforehand, as it allows for dynamic memory allocation and $O(1)$ operations for both insertion and deletion.

### **Key Components**

1.  **Node Class**: Represents an individual element in the queue. Each node contains `data` (the value) and `next` (a pointer/reference to the next node in the sequence).
2.  **`myQueue` Class**: Manages the nodes using two main pointers:
    *   `front`: Points to the first node in the queue. This is where elements are removed (`dequeue`).
    *   `rear`: Points to the last node in the queue. This is where new elements are added (`enqueue`). 
    *   `size`: An integer tracking the current number of elements in the queue.

### **Core Operations**

*   **`enqueue(int x)`**: 
    *   If the queue is empty (`front == null`), both `front` and `rear` are set to the new node. 
    *   Otherwise, the new node is attached to the `rear.next` and then the `rear` pointer is updated to the current new node.
*   **`dequeue()`**: 
    *   Moves the `front` pointer to `front.next`. This effectively removes the node from the head of the list. 
    *   The `size` is decremented. 
    *   Special care must be taken in a real-world scenario to ensure the `rear` is also set to `null` if the queue becomes empty after a dequeue, though in this implementation, the `front` being `null` handles emptiness check.
*   **`isEmpty()`**: 
    *   Returns `true` if `size == 0` or `front == null`.
*   **`getFront()`**: 
    *   Simply returns the `front.data`. Returns `-1` if the queue is empty.
*   **`size()`**: 
    *   Returns the current value of the `size` variable.

## 3. **Complexity Analysis**

*   **Time Complexity**:
    *   `enqueue(int x)`: $O(1)$ - Constant time, as we are only updating pointer references.
    *   `dequeue()`: $O(1)$ - Constant time, as we are only shifting the head pointer.
    *   `isEmpty()`: $O(1)$ - Constant time.
    *   `getFront()`: $O(1)$ - Constant time.
    *   `size()`: $O(1)$ - Constant time.

*   **Space Complexity**:
    *   $O(n)$ - Where $n$ is the number of elements stored in the queue, as each element requires a new node in memory.

## 4. **Dry Run**

**Example Scenario**:
1.  `q = new myQueue()` (Queue is empty: `front=null`, `rear=null`, `size=0`)
2.  `q.enqueue(10)`
    *   `newNode` with `data=10` created.
    *   `front` and `rear` both point to `newNode`.
    *   `size=1`.
3.  `q.enqueue(20)`
    *   `newNode` with `data=20` created.
     মিশন
    *   `rear.next` (which was 10's next) becomes `newNode`(20).
    *   `rear` moves to `newNode`(20).
    *   `size=2`.
4.  `q.enqueue(30)`
    *   `size=3`.
    *   `front` points to 10, `rear` points to 30.
5.  `q.dequeue()`
    *   `front` moves from node 10 to node 20.
    *   `size=2`.
    *   Current state: `front` points to 20, `rear` points to 30. `20 -> 30`.
6.  `q.getFront()`
    *   Returns `20`.
7.  `q.dequeue()`
    *   `front` moves from node 20 to node 30.
    *   `size=1`.
    *   Current state: `front` points to 30, `rear=30`.
8.  `q.isEmpty()`
    *   Returns `false` (since `size=1`).

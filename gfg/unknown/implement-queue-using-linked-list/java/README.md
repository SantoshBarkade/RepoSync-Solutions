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


## AI Solution Notes

## 1. **Brute Force Approach**

In the context of implementing a queue using a linked list, a 'brute force' approach might involve using a fixed-size array. However, since the size of the queue is not predefined, a static array would lead to inefficient space usage or overflow errors. An alternative brute-force method would be be to use a dynamic array (like `ArrayList` in Java) to simulate a queue. While functional, this approach requires expensive $O(N)$ time complexity for `dequeue` operations because all subsequent elements in the array must be shifted one position to the left to fill the gap created at the front. 

## 2. **Optimal Approach**

The provided solution implements a queue using a **Singly Linked List** via a custom `Node` class and a `myQueue` class. This is the optimal approach for a dynamic queue because it allows for $O(1)$ time complexity for both insertion (enqueue) and deletion (dequeue) without the need for resizing or shifting elements.

### Key Components:
1. **Node Class**: 
   - Stores `data` (integer) and a pointer/reference `next` to the next node in the sequence.
2. **myQueue Class Members**:
   - `front`: A pointer to the first node in the queue. This is where deletions occur.
   - `rear`: A pointer to the last node in the queue. This is where insertions occur.
   - `size`: An integer tracking the current number of elements.

### Operations Logic:
- **`enqueue(int x)`**: 
   - A new node is created with value `x`.
   - If the queue is empty (`front == null`), both `front` and `rear` are set to the new node.
   - If the queue is not empty, the current `rear.next` is linked to the new node, and the `rear` pointer is updated to this new node.
   - The `size` is incremented.
- **`dequeue()`**: 
   - If the queue is empty, the function returns immediately.
   - The `front` pointer is moved to `front.next`. 
   - The *Note*: To ensure complete memory management in languages like C++, one would delete the node; in Java, the Garbage Collector handles the unreferenced node.
   - The `size` is decremented.
- **`getFront()`**: 
   - Simply returns the data of the node pointed to by `front`. Returns `-1` if empty.
- **`isEmpty()`**: 
   - Returns `true` if `size == 0`.

## 3. **Complexity Analysis**

### Time Complexity:
- **`enqueue(int x)`**: $O(1)$ - We only perform a constant number of pointer updates at the rear.
- **`dequeue()`**: $O(1)$ - We only update the front pointer to the next node.
- **`getFront()`**: $O(1)$ - Direct access via the `front` pointer.
- **`isEmpty()``**: $O(1)$ - Simple integer comparison.
- **`size()`**: $O(1)$ - Returns a pre-calculated size variable.

### Space Complexity:
- **Total Space**: $O(N)$, where $N$ is the number of the elements stored in the queue, as each element requires a dedicated `Node` object in memory.
- **Auxiliary Space**: $O(1)$ per operation, as no additional significant memory is used beyond the node itself and a few pointers.

## 4. **Dry Run**

**Scenario**: 
1. `enqueue(10)`
2. `enqueue(20)`
3. `dequeue()`
4. `getFront()`

**Step-by-Step Execution**:

1. **Initial State**: 
   - `front = null`, `rear = null`, `size = 0`.

2. **`enqueue(10)`**:
   - New Node(10) created.
   - `front = null`, so `front = Node(10)`, `rear = Node(10)`. 
   - `size = 1`.
   - *Queue Structure*: `[10] -> null` (front is 10).

3. **`enqueue(20)`**:
   - New Node(20) created.
   - `front` is not `null`, so `rear.next = Node(20)` and `rear = Node(20)`.
   - `size = 2`.
   - *Queue Structure*: `[10] -> [20] -> null` (front is 10, rear is 20).

4. **`dequeue()`**:
   - `front` is not `null`.
   - `front = front.next` (front now points to Node(20)).
   - `size = 1`.
   - *Queue Structure*: `[20] -> null` (front is 20, rear is 20).

5. **`getFront()`**:
   - `front` is Node(20), so `front.data = 20`.
   - **Result**: `20`.

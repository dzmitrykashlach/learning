package com.algorithms.storehouse.entities.stack

/**
 * Implement a simple stack.
 * <br></br>
 * The Stack structure represents a last-in-first-out (LIFO) stack of objects.
 */
class SimpleStack<T> {
    internal inner class StackNode(val element: T) {
        var previous: StackNode? = null
    }

    private var first: StackNode? = null
    private var size = 0

    /**
     * Pushes an item onto the top of this stack.
     * Params:
     * item – the item to be pushed onto this stack.
     * @param item
     */
    fun push(item: T) {
        if (first == null) {
            first = StackNode(item)
        } else {
            val previous = first
            first = StackNode(item)
            first!!.previous = previous
        }
        size++
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * Returns:
     * The object at the top of this stack OR null if the stack is empty
     */
    fun pop(): T? {
        return if (size > 0) {
            val e = first
            first = first!!.previous
            size--
            e!!.element
        } else {
            null
        }
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * Returns:
     * the object at the top of this stack OR null if the stack is empty
     */
    fun peek(): T {
        return first!!.element
    }

    /**
     * Returns number of the objects stored in the stack
     */
    fun size(): Int {
        return size
    }

    /**
     * Clears the stack
     */
    fun clear() {
        first = null
    }
}
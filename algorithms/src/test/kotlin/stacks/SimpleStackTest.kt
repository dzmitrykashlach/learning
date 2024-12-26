package stacks

import com.algorithms.storehouse.entities.stack.SimpleStack
import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

/**
 * Simple test of the stack
 */
class SimpleStackTest {
    private val stack = SimpleStack<String>()
    @BeforeTest
    fun setup() {
        stack.clear()
    }

    @Test
    fun testPushPeekPopSize() {
        assertEquals(stack.size().toLong(), 0)
        stack.push("one")
        stack.push("two")
        stack.push("three")
        assertEquals(stack.size().toLong(), 3)
        assertEquals(stack.peek(), "three")
        assertEquals(stack.pop(), "three")
        assertEquals(stack.pop(), "two")
        assertEquals(stack.pop(), "one")
        assertEquals(stack.size().toLong(), 0)
    }

    @Test
    fun testPopMore() {
        assertEquals(stack.size().toLong(), 0)
        stack.push("one")
        stack.push("two")
        assertEquals(stack.size().toLong(), 2)
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
    }
}
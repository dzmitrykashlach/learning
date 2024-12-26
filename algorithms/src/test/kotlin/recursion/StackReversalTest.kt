package recursion

import com.algorithms.storehouse.logic.recursion.StackReversal
import kotlin.test.Test
import java.util.*

class StackReversalTest {

    @Test
    fun reverse(){
        val stack = Stack<Int>()
        stack.push(0)
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        stack.push(6)
        StackReversal(stack).reverse()
    }
}
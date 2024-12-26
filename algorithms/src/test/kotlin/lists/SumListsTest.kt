package lists

import com.algorithms.storehouse.logic.linkedlist.SumLists
import java.util.LinkedList
import kotlin.test.Test
import kotlin.test.assertEquals

class SumListsTest {

    @Test
    fun sumListsTest() {
        val sl = SumLists()
        val l1 = LinkedList<Int>()
        l1.add(7)
        l1.add(1)
        l1.add(6)
        val l2 = LinkedList<Int>()
        l2.add(5)
        l2.add(9)
        l2.add(2)
        val l3 = sl.execute(l1, l2)
        assertEquals(3, l3.size)
        assertEquals(2, l3.first())
        assertEquals(1, l3[1])
        assertEquals(9, l3.last())
    }
}
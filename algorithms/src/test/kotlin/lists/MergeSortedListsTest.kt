package lists

import com.algorithms.storehouse.entities.linkedlist.LinkedListNode
import com.algorithms.storehouse.logic.linkedlist.MergeLists
import kotlin.test.Test
import kotlin.test.assertEquals

class MergeSortedListsTest {
    /*
    Example 1:
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6

    Example 2:
    Input: lists = []
    Output: []

    Example 3:
    Input: lists = [[]]
    Output: []
     */
    @Test
    fun `merge 2 arrays`() {
        val ll1 = LinkedListNode(
            1,
            LinkedListNode(
                7,
                LinkedListNode(9)
            )
        )

        val ll2 = LinkedListNode(
            2,
            LinkedListNode(
                8,
                LinkedListNode(10)
            )
        )


        val llists = arrayOf(ll1, ll2)
        val merge = MergeLists()
        val rl = merge.perform(llists)
        assertEquals(rl!!.value, 1)
        assertEquals(rl.next!!.value, 2)
        assertEquals(rl.next!!.next!!.value, 7)
        assertEquals(rl.next!!.next!!.next!!.value, 8)
        assertEquals(rl.next!!.next!!.next!!.next!!.value, 9)
        assertEquals(rl.next!!.next!!.next!!.next!!.next!!.value, 10)

    }

    @Test
    fun `merge 3 arrays`() {
        val ll1 = LinkedListNode(
            1,
            LinkedListNode(
                4,
                LinkedListNode(5)
            )
        )

        val ll2 = LinkedListNode(
            1,
            LinkedListNode(
                3,
                LinkedListNode(4)
            )
        )

        val ll3 = LinkedListNode(
            2,
            LinkedListNode(
                6
            )
        )

        val llists = arrayOf(ll1, ll2, ll3)
        val merge = MergeLists()
        val rl = merge.perform(llists)
        assertEquals(rl!!.value, 1)
        assertEquals(rl.next!!.value, 1)
        assertEquals(rl.next!!.next!!.value, 2)
        assertEquals(rl.next!!.next!!.next!!.value, 3)
        assertEquals(rl.next!!.next!!.next!!.next!!.value, 4)
        assertEquals(rl.next!!.next!!.next!!.next!!.next!!.value, 4)
        assertEquals(rl.next!!.next!!.next!!.next!!.next!!.next!!.value, 5)
        assertEquals(rl.next!!.next!!.next!!.next!!.next!!.next!!.next!!.value, 6)
    }

    @Test
    fun `merge zero arrays`() {
        val llists = emptyArray<LinkedListNode>()
        val merge = MergeLists()
        val rl = merge.perform(llists)
        assertEquals(null, rl)
    }
}
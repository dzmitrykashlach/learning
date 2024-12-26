package lists.leetcode

import com.algorithms.storehouse.entities.linkedlist.leetcode.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseLinkedList {

    /*
    https://medium.com/outco/reversing-a-linked-list-easy-as-1-2-3-560fbffe2088
    */
    fun reverseIterative(l: ListNode, left: Int, right: Int): ListNode {
        if (left >= right) {
            return l
        }
        var current = l
        var previous: ListNode? = null
        for (i in 0 until left) {
            if (i == left - 1) {
                previous = current
            }
            if (current.next == null) {
                return l
            } else {
                current = current.next!!
            }
        }
        val prevLeftNode = previous
        prevLeftNode!!.next = null
        val leftNode = current
        var following: ListNode? = current
        for (i in left..right) {
            following = following!!.next
            current.next = previous
            previous = current
            current = following!!
        }
        leftNode.next = current.next
        current.next = previous
        prevLeftNode!!.next = current
        leftNode.next
        return l
    }

    @Test
    fun `01234567 --- 2,5`() {
        val l: ListNode = get01234567()

        val r = ReverseLinkedList().reverseIterative(l, 2, 5)
        assertEquals(6, r.next!!.next!!.`val`)
        assertEquals(2, r.next!!.next!!.next!!.next!!.next!!.next!!.`val`)
        assertEquals(7, r.next!!.next!!.next!!.next!!.next!!.next!!.next!!.`val`)
        assertEquals(null, r.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next)
    }


    fun `get01234567`() = ListNode(
        0,
        ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode(
                            5,
                            ListNode(
                                6,
                                ListNode(7)
                            )
                        )
                    )
                )
            )
        )
    )
}
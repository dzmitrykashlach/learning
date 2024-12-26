package lists.leetcode

import com.algorithms.storehouse.entities.linkedlist.leetcode.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveNthNode {

    fun remove(l: ListNode, n: Int): ListNode {
        if (n == 0) {
            return l
        }
        var p1 = l
        var p2: ListNode? = l
        for (i in 1..n) {
            if (p1.next != null) {
                p1 = p1.next!!
            }
        }
        while (p1.next != null) {
            if (p2 != null) {
                p2 = p2.next!!
            }
            p1 = p1.next!!
        }
        if (p2 != null) {
            if (p2.equals(l)) {
                return p2.next!!
            }

            when (n) {
                1 -> p2?.next = null
                else -> if (p2 != null) {
                    p2.next = p2.next!!.next!!
                }
            }
        }
        return l
    }


    @Test
    fun `n=3`() {
        val l: ListNode = ListNode(
            0,
            ListNode(
                1,
                ListNode(
                    2,
                    ListNode(
                        3,
                        ListNode(
                            4,
                            ListNode(5)
                        )
                    )
                )
            )
        )
        val r = RemoveNthNode().remove(l, 3)
        assertEquals(0, r?.`val`)
        assertEquals(1, r?.next?.`val`)
        assertEquals(2, r?.next?.next?.`val`)
        assertEquals(4, r?.next?.next?.next?.`val`)
        assertEquals(5, r?.next?.next?.next?.next?.`val`)
        assertEquals(null, r?.next?.next?.next?.next?.next)
    }

    @Test
    fun `n=0`() {
        val l: ListNode = ListNode(
            0,
            ListNode(
                1,
                ListNode(
                    2,
                    ListNode(
                        3,
                        ListNode(
                            4,
                            ListNode(5)
                        )
                    )
                )
            )
        )
        val r = RemoveNthNode().remove(l, 0)
        assertEquals(0, r?.`val`)
        assertEquals(1, r?.next?.`val`)
        assertEquals(2, r?.next?.next?.`val`)
        assertEquals(3, r?.next?.next?.next?.`val`)
        assertEquals(4, r?.next?.next?.next?.next?.`val`)
        assertEquals(5, r?.next?.next?.next?.next?.next?.`val`)
    }

    @Test
    fun `n=1`() {
        val l: ListNode = ListNode(
            0,
            ListNode(
                1,
                ListNode(
                    2,
                    ListNode(
                        3,
                        ListNode(
                            4,
                            ListNode(5)
                        )
                    )
                )
            )
        )
        val r = RemoveNthNode().remove(l, 1)
        assertEquals(0, r?.`val`)
        assertEquals(1, r?.next?.`val`)
        assertEquals(2, r?.next?.next?.`val`)
        assertEquals(3, r?.next?.next?.next?.`val`)
        assertEquals(4, r?.next?.next?.next?.next?.`val`)
        assertEquals(null, r?.next?.next?.next?.next?.next)
    }

    @Test
    fun `n=6`() {
        val l: ListNode = ListNode(
            0,
            ListNode(
                1,
                ListNode(
                    2,
                    ListNode(
                        3,
                        ListNode(
                            4,
                            ListNode(5)
                        )
                    )
                )
            )
        )
        val r = RemoveNthNode().remove(l, 6)
        assertEquals(1, r?.`val`)
        assertEquals(2, r?.next?.`val`)
        assertEquals(3, r?.next?.next?.`val`)
        assertEquals(4, r?.next?.next?.next?.`val`)
        assertEquals(5, r?.next?.next?.next?.next?.`val`)
    }
}
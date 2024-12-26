package lists.leetcode

import com.algorithms.storehouse.entities.linkedlist.leetcode.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class SwapNodesPairs {

/*
https://www.enjoyalgorithms.com/blog/swap-list-nodes-in-pairs
 */
    fun swap(l: ListNode): ListNode? {
        if (l.next == null) {
            return l
        }
        var p:ListNode? = l
        var head = l.next
        while (p != null && p.next != null) {
            val tmp = p.next
            p.next = p.next!!.next
            tmp?.next = p
            p = p.next
            if (p!=null && p.next!=null){
                if (tmp != null) {
                    tmp.next?.next = p.next
                }
            }
        }

        return head
    }

    @Test
    fun `1-2-3-4`() {
        val l: ListNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4
                    )
                )
            )
        )

        var r = SwapNodesPairs().swap(l)
        assertEquals(2, r!!.`val`)
        assertEquals(1, r!!.next?.`val`)
        assertEquals(4, r!!.next?.next?.`val`)
        assertEquals(3, r!!.next?.next?.next?.`val`)
    }

    @Test
    fun `1-2-3-4-5`() {
        val l: ListNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode(
                            5
                        )
                    )
                )
            )
        )

        var r = SwapNodesPairs().swap(l)

        assertEquals(2, r!!.`val`)
        assertEquals(1, r!!.next?.`val`)
        assertEquals(4, r!!.next?.next?.`val`)
        assertEquals(3, r!!.next?.next?.next?.`val`)
        assertEquals(5, r!!.next?.next?.next?.next?.`val`)
    }

    @Test
    fun `1`() {
        val l: ListNode = ListNode(
            1
        )

        var r = SwapNodesPairs().swap(l)
        assertEquals(1, r!!.`val`)
    }
}
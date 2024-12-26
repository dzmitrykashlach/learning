package lists.leetcode

import com.algorithms.storehouse.entities.linkedlist.leetcode.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals




class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l3: ListNode = ListNode(0)
        var p1 = l1
        var p2 = l2
        val head = l3
        while (p1 != null || p2 != null) {
            l3.`val` = l3.`val` +
                    if (p1 != null) {p1.`val`} else {0} +
                    if (p2 != null) {p2.`val`} else {0}
            p1 = p1?.next
            p2 = p2?.next
            if (l3.`val` >= 10) {
                l3.`val` = l3.`val` - 10
                l3.next = ListNode(1)
            } else {
                if (p1 == null && p2 == null) {
                    break
                }
                l3.next = ListNode(0)
            }
            l3 = l3.next!!
        }
        return head
    }

    @Test
    fun `708`() {
        val l1: ListNode? = ListNode(
            2,
            ListNode(
                4,
                ListNode(3)
            )
        )
        val l2: ListNode? = ListNode(
            5,
            ListNode(
                6,
                ListNode(4)
            )
        )
        val l3 = AddTwoNumbers().addTwoNumbers(l1, l2)
        assertEquals(7, l3?.`val`)
        assertEquals(0, l3?.next?.`val`)
        assertEquals(8, l3?.next?.next?.`val`)
        assertEquals(null, l3?.next?.next?.next)
    }

    @Test
    fun `89990001`() {
        val l1: ListNode? = ListNode(
            9,
            ListNode(
                9,
                ListNode(
                    9,
                    ListNode(
                        9,
                        ListNode(
                            9,
                            ListNode(
                                9,
                                ListNode(9)
                            )
                        )
                    )
                )
            )
        )
        val l2: ListNode? = ListNode(
            9,
            ListNode(
                9,
                ListNode(
                    9,
                    ListNode(9)
                )
            )
        )
        val l3 = AddTwoNumbers().addTwoNumbers(l1, l2)
        assertEquals(8, l3?.`val`)
        assertEquals(9, l3?.next?.`val`)
        assertEquals(9, l3?.next?.next?.`val`)
        assertEquals(9, l3?.next?.next?.next?.`val`)
        assertEquals(0, l3?.next?.next?.next?.next?.`val`)
        assertEquals(0, l3?.next?.next?.next?.next?.next?.`val`)
        assertEquals(0, l3?.next?.next?.next?.next?.next?.next?.`val`)
        assertEquals(1, l3?.next?.next?.next?.next?.next?.next?.next?.`val`)
    }
}
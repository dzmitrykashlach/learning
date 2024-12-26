package lists

import com.algorithms.storehouse.entities.linkedlist.SinglyLinkedListNode
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
class ReverseNodesTest {

    /*
    in = 0,1,2,3,4,5,6,7,8,9 k=5
   out = 3,2,1,0,8,7,6,5,4,9
     */

    private var initList = fun(head: SinglyLinkedListNode): SinglyLinkedListNode {
        head.next = SinglyLinkedListNode(1)
        var next = head.next
        for (i in 2..9) {
            next!!.next = SinglyLinkedListNode(i)
            next = next.next
        }
        return head
    }

    @Test
    fun kLessThanListSize() {
        var head = SinglyLinkedListNode(0)
            .also { initList(it) }
        head = head.reverseKNode(head, 5)
        assertTrue(head.number == 4)
        assertTrue(head.next!!.next!!.next!!.next!!.number == 0)
        assertTrue(head.next!!.next!!.next!!.next!!.next!!.number == 8)
        var tail = head
        tail.apply {
            while (tail.next!!.next != null) {
                tail = tail.next!!
            }
        }
        assertTrue(tail.number == 5)
        assertTrue(tail.next!!.number == 9)


    }

    @Test
    fun kEqualMoreThanListSize() {
        var head = SinglyLinkedListNode(0)
            .also { initList(it) }
        assertFailsWith<RuntimeException>(
            message = "No exception found",
            block = {
                head.reverseKNode(head, 11)
            }
        )
        assertFailsWith<RuntimeException>(
            message = "No exception found",
            block = {
                head.reverseKNode(head, 10)
            }
        )
    }


    @Test
    fun singleHead() {
        var head = SinglyLinkedListNode(0)
        assertFailsWith<RuntimeException>(
            message = "No exception found",
            block = {
                head.reverseKNode(head,0)
            }
        )
    }
}
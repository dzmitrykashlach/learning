import linkedlists.LinkedListsIntersection
import linkedlists.ListNode
import kotlin.test.assertFailsWith
import kotlin.test.Test
import kotlin.test.assertEquals

class ListsIntersectionTest {

    @Test
    fun positiveQuadratic(){
        val head1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(7)
        head1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        val head2 = ListNode(11)
        val node12 = ListNode(12)
        val node13 = ListNode(13)
        val node14 = ListNode(14)
        head2.next = node12
        node12.next = node13
        node13.next = node14
        node14.next = node3
        val intersection = LinkedListsIntersection(head1, head2)
        assertEquals(3,intersection.findQuadratic().value)
    }

    @Test
    fun positiveQuadraticHead(){
        val head1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        head1.next = node2
        node2.next = node3

        val intersection = LinkedListsIntersection(head1, head1)
        assertEquals(1,intersection.findQuadratic().value)
    }

    @Test
    fun positiveQuadraticTail(){
        val head1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        head1.next = node2
        node2.next = node3
        val head2 = node3

        val intersection = LinkedListsIntersection(head1, head2)
        assertEquals(3,intersection.findQuadratic().value)
    }

    @Test
    fun negativeQuadratic(){
        val head1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(7)
        head1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        val head2 = ListNode(11)
        val node12 = ListNode(12)
        val node13 = ListNode(13)
        val node14 = ListNode(14)
        head2.next = node12
        node12.next = node13
        node13.next = node14
        val intersection = LinkedListsIntersection(head1, head2)
        assertFailsWith<RuntimeException>(
            block = {
                intersection.findQuadratic()
            }
        )
    }

    @Test
    fun positiveLinear(){
        val head1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(7)
        head1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        val head2 = ListNode(11)
        val node12 = ListNode(12)
        val node13 = ListNode(13)
        val node14 = ListNode(14)
        head2.next = node12
        node12.next = node13
        node13.next = node14
        node14.next = node3
        val intersection = LinkedListsIntersection(head1, head2)
        assertEquals(3,intersection.findLinear().value)
    }

    @Test
    fun negativeLinear(){
        val head1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(7)
        head1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        val head2 = ListNode(11)
        val node12 = ListNode(12)
        val node13 = ListNode(13)
        val node14 = ListNode(14)
        head2.next = node12
        node12.next = node13
        node13.next = node14
        val intersection = LinkedListsIntersection(head1, head2)
        assertFailsWith<RuntimeException>(
            block = {
                intersection.findLinear()
            }
        )
    }
}
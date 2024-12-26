package linkedlists

import org.openjdk.jmh.annotations.*

@State(Scope.Benchmark)
class LinkedListsBenchMarks {
    val head1 = ListNode(1)
    val head2 = ListNode(2)

    @Param(value = [])
    var listSize: Int = 0

    @Setup
    fun initLists() {
        var pointer1 = head1;
        var intersection = head1
        for (i in 2..listSize) {
            pointer1.next = ListNode(i)
            pointer1 = pointer1.next
            if (i == listSize / 2) {
                intersection = pointer1
            }
        }
        var pointer2 = head2
        for (j in listSize..listSize + listSize / 2) {
            pointer2.next = ListNode(j)
            pointer2 = pointer2.next
        }
        pointer2.next = intersection
    }

    @Benchmark
    fun findQuadratic() {
        val listsIntersection = LinkedListsIntersection(head1, head2)
        listsIntersection.findQuadratic()
    }

    @Benchmark
    fun findLinear() {
        val listsIntersection = LinkedListsIntersection(head1, head2)
        listsIntersection.findLinear()
    }
}
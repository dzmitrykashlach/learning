package linkedlists

class LinkedListsIntersection(
    private val head1: ListNode,
    private val head2: ListNode
) {
    @Throws(RuntimeException::class)
    fun findQuadratic(): ListNode {
        var pointer1 = head1
        var pointer2 = head2
        while (pointer1 != ListNode.empty) {
            while (pointer2 != ListNode.empty) {
                if (pointer1 === pointer2) {
                    return pointer2
                } else {
                    pointer2 = pointer2.next
                }
            }
            pointer1 = pointer1.next
            pointer2 = head2
        }
        throw RuntimeException("No intersection between lists")
    }

    fun findLinear(): ListNode {
        var next1 = head1
        next1.visited = true
        var next2 = head2
        while (next1 != ListNode.empty) {
            next1.next.visited = true
            if (next2 != ListNode.empty && next2.visited) {
                return next2
            } else if (next2 != ListNode.empty) {
                next2 = next2.next
            }
            next1 = next1.next
        }
        throw RuntimeException("No intersection between lists")
    }
}

class ListNode(
    var value: Int
) {
    var visited: Boolean = false
    var next: ListNode = empty

    companion object {
        val empty = ListNode(Int.MAX_VALUE)
    }
}
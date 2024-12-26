package com.algorithms.storehouse.entities.linkedlist

class SinglyLinkedListNode(val number: Int) {
    var next: SinglyLinkedListNode? = null

    /*
    this function reverses separately parts of singly-linked list from head to k-1 and from k t0 tail-1
    https://www.geeksforgeeks.org/reverse-a-linked-list/
    */
    fun reverseKNode(head: SinglyLinkedListNode, k: Int): SinglyLinkedListNode {
        if(head.next==null){
            throw RuntimeException("Please, provide valid list")
        }
        var tail: SinglyLinkedListNode = head
        var kNode: SinglyLinkedListNode = head

        tail.apply {
            var moves = 0
            while (moves < k) {
                if (tail.next == null) {
                    throw RuntimeException("k is equal or more than list size")
                }
                tail = tail.next!!
                kNode = kNode.next!!
                moves += 1
            }
        }

//      reverse from head to k-1
        var head2K = reverse(head, k)
        var head = head2K.first
        var moves = 0
        tail.apply {
            while (tail.next != null) {
                tail = tail.next!!
                moves += 1
            }
        }

//      reverse from k to tail-1
        var k2tail = reverse(kNode, moves)
//      combine results
        head2K.second.next = k2tail.first
        k2tail.second.next = tail

        return head
    }

    fun reverse(head: SinglyLinkedListNode, k: Int): Pair<SinglyLinkedListNode, SinglyLinkedListNode> {
        var head = head
        var preKnode = head
        var prev: SinglyLinkedListNode? = null
        var next: SinglyLinkedListNode?

        var kNode: SinglyLinkedListNode = head
        var moves: Int = 0
        while (moves < k) {
            next = kNode.next
            kNode.next = prev
            prev = kNode
            if (next != null) {
                kNode = next
            }
            moves += 1
        }
        if (prev != null) {
            head = prev
        }
        return Pair(head, preKnode)
    }
}

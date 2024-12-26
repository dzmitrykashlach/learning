package com.algorithms.storehouse.entities.linkedlist

/*
https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/lecture/24146546#overview
 */
class CircularSinglyLinkedList(number: Int) {
    var head: SinglyLinkedListNode
    var tail: SinglyLinkedListNode
    var size = 0

    init {
        val node = SinglyLinkedListNode(number)
        node.next = node
        head = node
        tail = node
        size++
    }

    fun insert(number: Int, position: Int) {
        val node = SinglyLinkedListNode(number)
        if (position == 0) {
            head = node
            tail = node
            node.next = node
            size++
            return
        }
        if (position - 1 == size) {
            tail = node
            node.next = head
            head.next = node
        } else {
            val nodePos = iterateToPosition(position - 1)
            val nodeNextPos = nodePos!!.next
            nodePos.next = node
            node.next = nodeNextPos
        }
        size++
    }

    private fun iterateToPosition(position: Int): SinglyLinkedListNode? {
        var nodeAtPosition: SinglyLinkedListNode? = head
        for (i in 0 until position - 1) {
            nodeAtPosition = nodeAtPosition!!.next
        }
        return nodeAtPosition
    }

    class SinglyLinkedListNode(val number: Int) {
        var next: SinglyLinkedListNode? =
            null

    }
}
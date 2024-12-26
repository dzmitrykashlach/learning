package com.algorithms.storehouse.logic.linkedlist

import com.algorithms.storehouse.entities.linkedlist.LinkedListNode

class MergeLists {
    /*

    If the number of lists is 0, return NULL as there are no lists to merge.
    If there is only one list, return that list as the merged result.
    Divide the k lists into two halves.
    Recursively merge the first half of the lists.
    Recursively merge the second half of the lists.
    Merge the two merged lists obtained from steps 4 and 5 into a single sorted list.
     */
    fun perform(llists: Array<LinkedListNode>): LinkedListNode? {
        if (llists.size == 0) {
            return null
        }
        if (llists.size == 1) {
            return llists[0]
        }
        if (llists.size == 2) {
            return mergeLists(llists[0], llists[1])
        }

        if (llists.size > 2) {
            val middle = llists.size / 2

            val left = perform(llists.sliceArray(0..middle))
            var right = perform(llists.sliceArray(middle + 1..llists.size - 1))
//            merge left & right
//            val mergedList = LinkedListNode()
            return mergeLists(left!!, right!!)
        }


        return null
    }


    fun mergeLists(l1: LinkedListNode, l2: LinkedListNode): LinkedListNode? {
        val resultHead = LinkedListNode(0)
        var current = resultHead
        var list1:LinkedListNode? = l1
        var list2:LinkedListNode? = l2

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                current.next = list1
                    .also { list1 = list1.next }
            } else {
                current.next = list2
                    .also { list2 = list2.next }
            }
            current = current.next!!
        }

        current.next = list1 ?: list2

        return resultHead.next
    }
}
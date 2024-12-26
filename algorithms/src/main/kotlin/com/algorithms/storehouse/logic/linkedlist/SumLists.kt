package com.algorithms.storehouse.logic.linkedlist

import java.util.LinkedList
import kotlin.math.abs

class SumLists {
    fun execute(l1: LinkedList<Int>, l2: LinkedList<Int>): LinkedList<Int> {
        var p1 = l1.pollFirst()
        var p2 = l2.pollFirst()
        var l3 = LinkedList<Int>()
        var p3 = 0
        var surplus = 0
        while (l1.peekLast() != null) {
            p3 = sum(p1, p2, surplus)
            surplus = if ((p1 + p2) >= 10) 1 else 0
            l3.offerLast(p3)
            p1 = l1.pollFirst() ?: 0
            p2 = l2.pollFirst() ?: 0
        }
        l3.offerLast(sum(p1, p2, surplus))
        return l3
    }

    fun sum(p1: Int, p2: Int, surplus: Int): Int {
        return if ((p1 + p2) >= 10) abs(p1 + p2 - 10 + surplus) else p1 + p2 + surplus
    }
}
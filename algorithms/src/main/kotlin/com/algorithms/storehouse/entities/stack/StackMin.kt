package com.algorithms.storehouse.entities.stack

import lombok.Getter
import java.util.*

class StackMin<E : Comparable<E>> {
    val elements = LinkedList<Node<E>>()
    var min: Node<E>? = null

    class Node<E : Comparable<E>?>(@field:Getter var value: E, var nextMin: Node<E>?)

    fun push(e: E) {
        var nextMin: Node<E>? = null
        var node: Node<E>
        if (elements.size == 0) {
            node = Node(e, nextMin)
            min = node
        }
        if (e.compareTo(min!!.value) < 0) {
//           if added value is less than existing min value
            nextMin = min
            node = Node(e, nextMin)
            min = node
        } else {
//           if added value is greater than existing min value
            nextMin = min
            node = Node(e, nextMin)
        }
        elements.push(node)
    }

    fun pop(): Node<E> {
        if (elements.size > 1) {
            if (min === elements.peek()) {
                min = min!!.nextMin
            }
        } else {
            min = elements.peek()
        }
        return elements.pop()
    }

    fun min(): E {
        return min!!.value
    }

    fun size(): Int {
        return elements.size
    }
}
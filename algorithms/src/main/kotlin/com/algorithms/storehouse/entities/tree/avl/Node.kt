package com.algorithms.storehouse.entities.tree.avl


data class Node(
    val key: Int,
    var height: Int = 0,
    var left: Node? = null,
    var right: Node? = null
) {
//    field is used for counting inversions
    var size:Int = 0

    fun rotateLeft(): Node {
        val y = right
        val t2 = y?.left
        // Perform rotation

        if (y != null) {
            y.left = this
        }
        right = t2
        return y!!
    }

    fun rotateRight(): Node {
        val y = left
        val t2 = y?.right
        if (y != null) {
            y.right = this
        }
        left = t2
        return y!!
    }


    fun height(): Int {
        height = 1 + (left?.height ?: 0)
            .coerceAtLeast(right?.height ?: 0)
        return height
    }
}

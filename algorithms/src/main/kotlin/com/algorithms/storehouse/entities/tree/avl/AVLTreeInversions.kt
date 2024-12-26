package com.algorithms.storehouse.entities.tree.avl

class AVLTreeInversions(
    val root: Node,
):IAVLTree {
    var inversionsCount: Int = 0


    override    fun insertNode(parent: Node?, child: Int): Node {

        // Find the position and insert the node
        if (parent == null) return Node(child)

        if (child < parent.key) {
            parent.left = insertNode(parent.left, child)
            inversionsCount = inversionsCount + ((parent.right?.size ?: 0) + 1)
            return parent
        } else {
            parent.right = insertNode(parent.right, child)
        }

        parent.height()
        parent.size = (parent.left?.size ?: 0) + (parent.right?.size ?: 0) + parent.size + 1
        val balanceFactor: Int = balanceFactor(parent)
        return rebalance(parent,balanceFactor)
    }

}


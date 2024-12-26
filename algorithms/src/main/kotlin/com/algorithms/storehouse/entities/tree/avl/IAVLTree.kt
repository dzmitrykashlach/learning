package com.algorithms.storehouse.entities.tree.avl

/*
https://www.educative.io/answers/how-to-insert-a-node-in-an-avl-tree
 */
interface IAVLTree {

    // Insert a node
    fun insertNode(parent: Node?, child: Int): Node {

        // Find the position and insert the node
        if (parent == null) return Node(child)
        if (child < parent.key)
            parent.left = insertNode(parent.left, child)
        else if (child > parent.key) parent.right =
            insertNode(parent.right, child)
        else return parent
        parent.height()
        val balanceFactor: Int = balanceFactor(parent)
        return rebalance(parent,balanceFactor)
    }

    fun rebalance(parent: Node, balanceFactor: Int):Node {
        if (balanceFactor > 1) {
//                left-left imbalance
            if (parent.left?.let { balanceFactor(it) }!! > 0) {
                return parent.rotateRight()
            }
//                left-right imbalance
            else if (balanceFactor(parent.left!!) == -1) {
                parent.left = parent.left!!.rotateLeft()
                return parent.rotateRight()
            }
        }
        if (balanceFactor < -1) {
            // right-right imbalance
            if (parent.right?.let { balanceFactor(it) }!! <= -0) {
                return parent.rotateLeft()
            }
            // right-left imbalance
            else
                if (parent.right?.let { balanceFactor(it) } == 1) {
                    parent.right = parent.right!!.rotateRight()
                    return parent.rotateLeft()
                }

        }
        return parent
    }

    fun balanceFactor(node: Node): Int {
        return (node.left?.height ?: -1) - (node.right?.height ?: -1)
    }
}
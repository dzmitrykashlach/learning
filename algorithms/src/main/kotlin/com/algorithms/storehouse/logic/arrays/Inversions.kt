package com.algorithms.storehouse.logic.arrays

import com.algorithms.storehouse.entities.tree.avl.Node
import com.algorithms.storehouse.entities.tree.avl.AVLTreeInversions

/*
https://afteracademy.com/blog/inversion-count-in-an-array/
 */
class Inversions {

    fun avlTreeCount(arr: IntArray): Int {
        val avl = AVLTreeInversions(Node(arr[0]))
        for (i in 1..arr.size - 1) {
            avl.insertNode(avl.root, arr[i])
        }
        return avl.inversionsCount
    }
}
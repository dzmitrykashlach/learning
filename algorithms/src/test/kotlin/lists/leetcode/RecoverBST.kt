package lists.leetcode

import com.algorithms.storehouse.entities.tree.leetcode.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

/*
    https://leetcode.com/problems/recover-binary-search-tree/description/
    https://algo.monster/liteproblems/99
*/

class RecoverBST {
    var prev: TreeNode? = null
    var first: TreeNode? = null
    var second: TreeNode? = null

    fun recoverBST(treeNode: TreeNode) {
        inorder(treeNode)
        if (first !== null && second !== null) {
            var tmp = first!!.`val`
            first!!.`val` = second!!.`val`
            second!!.`val` = tmp
        }
    }

    fun inorder(treeNode: TreeNode?) {
        if (treeNode == null) {
            return
        }
        inorder(treeNode.left)

        // Process current node: Compare current node's value with previous node's value.
        if (prev != null && prev!!.`val` > treeNode.`val`) {
            // If this condition is true, a swapped node is found.
            // If it's the first swapped node, assign previousNode to firstSwappedNode.
            if (first == null) {
                first = prev
            }
            // Assign current node to secondSwappedNode.
            second = treeNode
        }
        // Update previous node to the current node before moving to the right subtree.
        prev = treeNode

        inorder(treeNode.right)
    }

    @Test
    fun `1-3-2-4`() {
        val treeNode = `get-1-3-2-4-tree`()
        RecoverBST().recoverBST(treeNode)
        assertEquals(2, treeNode.`val`)
    }

    @Test
    fun `1`() {
        val treeNode = TreeNode(1)
        RecoverBST().recoverBST(treeNode)
        assertEquals(1, treeNode.`val`)
    }

    fun `get-1-3-2-4-tree`(): TreeNode {
        val `1` = TreeNode(1)
        val `2` = TreeNode(2)
        val `3` = TreeNode(3)
        val `4` = TreeNode(4)

        `3`.left = `1`
        `3`.right = `4`
        `4`.left = `2`
        return `3`
    }
}
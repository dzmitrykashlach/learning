package trees.leetcode

import com.algorithms.storehouse.entities.tree.leetcode.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
space complexity = O(1)
 */

class FlattenBinaryTree {

    fun flattenLeftToRight(node: TreeNode): TreeNode {
        if (node.left?.left!=null){
            flattenLeftToRight(node.left!!)
        }
        if (node.left!=null){
                val right = node.right
                node.right = node.left
                node.left = null
                var downRight = node.right
                if (downRight != null) {
                    while (downRight?.right!=null){
                        downRight = downRight.right
                    }
                if (downRight != null) {
                    downRight.right = right
                }


            }
        }
        return node
    }




    @Test
    fun `1-2-3-4-5-6`(){
        val t = `get-1-2-3-4-5-6-tree`()
        val l = flattenLeftToRight(t)
        assertEquals(1,l.`val`)
        assertEquals(2,l.right!!.`val`)
        assertEquals(3,l.right!!.right!!.`val`)
        assertEquals(4,l.right!!.right!!.right!!.`val`)
        assertEquals(5,l.right!!.right!!.right!!.right!!.`val`)
        assertEquals(6,l.right!!.right!!.right!!.right!!.right!!.`val`)

    }

    @Test
    fun `1-2-3-5-10-6-4-7-8-9`(){
        val t = `get-1-2-3-5-10-6-4-7-8-9-tree`()
        val l = flattenLeftToRight(t)
        assertEquals(1,l.`val`)
        assertEquals(2,l.right!!.`val`)
        assertEquals(3,l.right!!.right!!.`val`)
        assertEquals(5,l.right!!.right!!.right!!.`val`)
        assertEquals(10,l.right!!.right!!.right!!.right!!.`val`)
        assertEquals(6,l.right!!.right!!.right!!.right!!.right!!.`val`)
        assertEquals(4,l.right!!.right!!.right!!.right!!.right!!.right!!.`val`)
        assertEquals(7,l.right!!.right!!.right!!.right!!.right!!.right!!.right!!.`val`)
        assertEquals(8,l.right!!.right!!.right!!.right!!.right!!.right!!.right!!.right!!.`val`)
        assertEquals(9,l.right!!.right!!.right!!.right!!.right!!.right!!.right!!.right!!.right!!.`val`)
    }

    fun `get-1-2-3-4-5-6-tree`(): TreeNode {
        val `1` =  TreeNode(1)
        val `2` =  TreeNode(2)
        val `3` =  TreeNode(3)
        val `4` =  TreeNode(4)
        val `5` =  TreeNode(5)
        val `6` =  TreeNode(6)
        `2`.left = `3`
        `2`.right = `4`
        `5`.right = `6`
        `1`.left = `2`
        `1`.right = `5`
        return `1`
    }

    fun `get-1-2-3-5-10-6-4-7-8-9-tree`(): TreeNode {
        val `1` =  TreeNode(1)
        val `2` =  TreeNode(2)
        val `3` =  TreeNode(3)
        val `4` =  TreeNode(4)
        val `5` =  TreeNode(5)
        val `6` =  TreeNode(6)
        val `7` =  TreeNode(7)
        val `8` =  TreeNode(8)
        val `9` =  TreeNode(9)
        val `10` =  TreeNode(10)
        `5`.left = `10`
        `3`.left = `5`
        `3`.right = `6`
        `2`.left = `3`
        `2`.right = `4`
        `8`.right = `9`
        `7`.right = `8`
        `1`.left = `2`
        `1`.right = `7`
        return `1`
    }

}
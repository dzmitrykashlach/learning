package trees.leetcode

import com.algorithms.storehouse.entities.tree.leetcode.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
*/
class BuildBiTreeWithHash {
    val indexes:HashMap<Int,Int> = HashMap()
    var postIndex:Int = 0
    fun build(inorder: IntArray, postorder: IntArray, inFrom:Int, inTo:Int):TreeNode?{
        if (inFrom>inTo){
            return null
        }

        val treeNode = TreeNode(postorder[postIndex])
        postIndex--

        if (inFrom == inTo){
            return treeNode
        }
        val nodeIndex = indexes[treeNode.`val`]
        treeNode.right = build(inorder,postorder,
                                nodeIndex!!+1,inTo
        )
        treeNode.left = build(inorder,postorder,
            inFrom,nodeIndex-1
        )


        return treeNode
    }


    fun perform(inorder: IntArray, postorder: IntArray):TreeNode?{
        for (i in 0 until  inorder.size){
            indexes[inorder[i]] = i
        }
        postIndex = inorder.size-1
        return build(inorder,postorder,0,inorder.size-1)
    }


    @Test
    fun `3,9,20,null,null,15,7-with hash`(){
        val inorder = intArrayOf(9,3,15,20,7)
        val postorder = intArrayOf(9,15,7,20,3)
        val tree = BuildBiTreeWithHash().perform(inorder,postorder)
        assertEquals(3,tree!!.`val`)
        assertEquals(9, tree.left!!.`val`)
        assertEquals(20, tree.right!!.`val`)
        assertEquals(15, tree.right!!.left!!.`val`)
        assertEquals(7, tree.right!!.right!!.`val`)
    }
}
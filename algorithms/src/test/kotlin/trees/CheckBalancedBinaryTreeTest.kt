package trees

import com.algorithms.storehouse.logic.tree.CheckBalancedBinaryTree
import kotlin.test.*

// https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
class CheckBalancedBinaryTreeTest {

    @Test
    fun balancedTreeTestDiff1() {
        val root = CheckBalancedBinaryTree.TreeNode(8)
        root.left = CheckBalancedBinaryTree.TreeNode(3)
        root.right = CheckBalancedBinaryTree.TreeNode(15)

        root.left!!.left = CheckBalancedBinaryTree.TreeNode(1)
        root.left!!.right = CheckBalancedBinaryTree.TreeNode(5)

        root.right!!.left = CheckBalancedBinaryTree.TreeNode(10)
        root.right!!.right = CheckBalancedBinaryTree.TreeNode(20)

        root.left!!.left!!.left = CheckBalancedBinaryTree.TreeNode(0)

        assertTrue { CheckBalancedBinaryTree().isBalanced(root) }

    }

    @Test
    fun balancedTreeTestDiff2() {
        val root = CheckBalancedBinaryTree.TreeNode(8)
        root.left = CheckBalancedBinaryTree.TreeNode(3)

        root.left!!.left = CheckBalancedBinaryTree.TreeNode(1)
        root.left!!.left!!.left = CheckBalancedBinaryTree.TreeNode(11)
        root.right = CheckBalancedBinaryTree.TreeNode(4)

        val check = CheckBalancedBinaryTree().isBalanced(root)
        assertFalse { check }
    }


    @Test
    fun balancedTreeTestDiff0() {
        val root = CheckBalancedBinaryTree.TreeNode(8)
        root.left = CheckBalancedBinaryTree.TreeNode(3)
        root.right = CheckBalancedBinaryTree.TreeNode(15)

        root.left!!.left = CheckBalancedBinaryTree.TreeNode(1)
        root.left!!.right = CheckBalancedBinaryTree.TreeNode(5)

        root.right!!.left = CheckBalancedBinaryTree.TreeNode(10)
        root.right!!.right = CheckBalancedBinaryTree.TreeNode(20)

        assertTrue { CheckBalancedBinaryTree().isBalanced(root) }

    }
}
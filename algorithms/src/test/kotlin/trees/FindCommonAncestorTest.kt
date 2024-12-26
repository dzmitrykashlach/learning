package trees

import com.algorithms.storehouse.logic.tree.CommonAncestor
import com.algorithms.storehouse.entities.tree.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

/*
 Find the first common ancestor of two nodes in a binary tree.
 Avoid storing additional nodes in a data structure.
 NOTE: This is not necessarily a binary search tree.

Example:

    int[] array = {5, 3, 6, 1, 9, 11};
    TreeNode root = new TreeNode(20);
    for (int a : array) {
      root.insertInOrder(a);
    }
    TreeNode n1 = root.find(1);
    TreeNode n9 = root.find(9);
    TreeNode ancestor = CommonAncestor.commonAncestor(root, n1, n9);
    System.out.println(ancestor.data);// expected data = 5
 */
class FindCommonAncestorTest {

    @Test
    fun findCommonAncQuadraticTest() {
        val array = intArrayOf(5, 3, 6, 1, 9, 11)
        val root = TreeNode(20)
        for (i in array) {
            root.insertInOrder(i)
        }
        val n1: TreeNode = root.find(1)!!
        val n9: TreeNode = root.find(9)!!
        val commonAnc = CommonAncestor().findQuadratic(n1, n9)
        assertEquals(5,commonAnc.data)
    }

    @Test
    fun findCommonAncLinearTest() {
        val array = intArrayOf(5, 3, 6, 1, 9, 11)
        val root = TreeNode(20)
        for (i in array) {
            root.insertInOrder(i)
        }
        val n1: TreeNode = root.find(1)!!
        val n9: TreeNode = root.find(9)!!
        val commonAnc = CommonAncestor().findLinear( n1, n9)
        assertEquals(5,commonAnc.data)
    }
}
package com.algorithms.storehouse.logic.tree

import kotlin.math.abs


/*
Step 1: The middle element of array is the root of our BST. So we create a
BST node of this value and add it to the queue with the left and right indices
of the range.

Step 2: Now we run a loop till queue is empty. Inside the loop, we first
remove the root node from the queue and update left and right child of it: 1)
Middle of left subarray [l, mid - 1] as the left child 2) Middle of right subarray
[mid + 1, r] as the right child.
Left child of root will be the middle value of subarray [l, mid - 1] and cover
the range [l, mid - 1].
Right child of root will be the middle value of subarray [mid + 1, r] and
cover the range [mid + 1, r].
We first create a BST node with the middle value of left subarray [l, mid -
1], update it as the left child of root and add it to the queue with updated
left and right indices of its range.
After this, we create a BST node with the middle value of right subarray
[l, mid - 1], update it as the right child of root and add it to the queue with
updated left and right indices of its range.


Step 3: Similarly, we keep removing nodes from the queue in the loop and
updating left and right children based on the middle value of the node range.
By end of the process, we return a pointer to the root node of the constructed
tree.
 */
class CheckBalancedBinaryTree(
) {



    fun isBalanced(node: TreeNode?): Boolean {
        /* If tree is empty then return true */if (node == null) return true

        /* Get the height of left and right sub trees */
        /* for height of left subtree */
        val lh = height(node.left)
        /* for height of right subtree */
        val rh = height(node.right)
        return (abs(lh - rh) <= 1 && isBalanced(node.left)
                && isBalanced(node.right))

        /* If we reach here then tree is not height-balanced
         */
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */ /*  The function Compute the "height" of a tree. Height
       is the number of nodes along the longest path from
       the root node down to the farthest leaf node.*/
    private fun height(node: TreeNode?): Int {
        /* base case tree is empty */
        return if (node == null) 0 else (1
                + height(node.left).coerceAtLeast(height(node.right)))

        /* If tree is not empty then height = 1 + max of
         left height and right heights */
    }

    data class TreeNode(
        var data: Int,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
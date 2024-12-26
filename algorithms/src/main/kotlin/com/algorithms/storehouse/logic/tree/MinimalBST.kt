package com.algorithms.storehouse.logic.tree



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
class MinimalBST(
    val array: IntArray

) {
    var root: TreeNode? = null
    fun build() {
        root = buildNodes(0, array.size - 1)
    }


    fun buildNodes(left: Int, right: Int): TreeNode? {
        if (left > right) return null
        var mid = left + (right - left) / 2
        var root = TreeNode(array[mid])
        root.left = buildNodes(left, mid - 1)
        root.right = buildNodes(mid + 1, right)
        return root
    }

    data class TreeNode(
        var data: Int,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
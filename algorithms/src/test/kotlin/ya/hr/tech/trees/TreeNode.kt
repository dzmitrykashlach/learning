package ya.hr.tech.trees

import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/tree-height?compiler=kotlin
 */

class TreeNode(
    val value: Int,
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var height: Int = 1

    fun addTreeNode(value: Int) {
        if (value < this.value) {
            if (left == null) {
                left = TreeNode(value)
            } else {
                left!!.addTreeNode(value)
            }
        } else if (value > this.value) {
            if (right == null) {
                right = TreeNode(value)
            } else {
                right!!.addTreeNode(value)
            }
        } else {
            return
        }

        height = 1 + maxOf(left?.height ?: 0, right?.height ?: 0)
    }


}

class TreeNodeTest {
    @Test
    fun testTreeHeight() {
        var root = TreeNode(7)
        listOf(1)
            .forEach { root.addTreeNode(it) }
        assertEquals(1, root.height)


        root = TreeNode(7)
        listOf(3, 2, 1, 9, 5, 4, 6)
            .forEach { root.addTreeNode(it) }
        assertEquals(4, root.height)

    }

}
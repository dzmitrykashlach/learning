package trees

import com.algorithms.storehouse.entities.tree.avl.AVLTree
import com.algorithms.storehouse.entities.tree.avl.Node
import kotlin.test.Test
import kotlin.test.assertEquals


class AVLTreeInversionsTest {

    @Test
    fun `Should rotate left`() {
        var root = Node(0)
        val r = Node(1)
        val rl = Node(2)
        root.right = r
        root.right!!.left = rl
        root = root.rotateLeft()
        assertEquals(root.key, 1)
        assertEquals(root.left!!.key, 0)
        assertEquals(root.left!!.right!!.key, 2)
    }

    @Test
    fun `Should rotate right`() {
        var root = Node(0)
        val l = Node(1)
        val lr = Node(2)
        root.left = l
        root.left!!.right = lr
        root = root.rotateRight()
        assertEquals(root.key, 1)
        assertEquals(root.right!!.key, 0)
        assertEquals(root.right!!.left!!.key, 2)
    }


    @Test
    fun `Should update height`() {
        var root = Node(0)
        val l = Node(1)
        root.left = l
        root.height()
        assertEquals(1, root.height)
    }

    @Test
    fun `Should calculate balance`() {
        var root = Node(0)
        val l = Node(1)
        val ll = Node(2)
        root.left = l
        root.height()
        root.left!!.left = ll
        root.left!!.height()
        root.height()
        val r = Node(3)
        root.right = r
        root.height()
        val avl = AVLTree(root)
        assertEquals(1, avl.balanceFactor(root))
    }

    @Test
    fun `Should fix left-right imbalance`() {
        var root = Node(8)
        val `3` = Node(3)
        val `5` = Node(5)
        val `6` = Node(6)
        val `15` = Node(15)

        root.left = `5`
        root.right = `15`
        root.height()

        `5`.left = `3`
        `5`.right = `6`
        `5`.height()
        root.height()

        val tree = AVLTree(root)
        root = tree.insertNode(root, 7)
        assertEquals(6, root.key)
        assertEquals(5, root.left!!.key)
        assertEquals(3, root.left!!.left!!.key)
        assertEquals(8, root.right!!.key)
        root.right!!.right?.let { assertEquals(15, it.key) }
        root.right!!.left?.let { assertEquals(7, it.key) }
    }

    @Test
    fun `Should fix left-left imbalance`() {
        var root = Node(8)
        val `3` = Node(3)
        val `5` = Node(5)
        val `6` = Node(6)
        val `15` = Node(15)

        root.left = `5`
        root.right = `15`
        root.height()

        `5`.left = `3`
        `5`.right = `6`
        `5`.height()
        root.height()

        val tree = AVLTree(root)
        root = tree.insertNode(root, 1)
        assertEquals(5, root.key)
        assertEquals(3, root.left!!.key)
        assertEquals(1, root.left!!.left!!.key)
        assertEquals(8, root.right!!.key)
        root.right!!.right?.let { assertEquals(15, it.key) }
        root.right!!.left?.let { assertEquals(6, it.key) }
    }

    @Test
    fun `Should fix right-right imbalance`() {
        var root = Node(8)
        val `15` = Node(15)
        val `16` = Node(16)

        root.right = `15`
        root.height()

        `15`.right = `16`
        `15`.height()
        root.height()

        val tree = AVLTree(root)
        root = tree.insertNode(root, 10)
        assertEquals(15, root.key)
    }

    @Test
    fun `Should fix right-left imbalance`() {
        var root = Node(8)
        val `15` = Node(15)
        val `14` = Node(14)

        root.right = `15`
        root.height()

        `15`.left = `14`
        `15`.height()
        root.height()

        val tree = AVLTree(root)
        root = tree.insertNode(root, 10)
        assertEquals(14, root.key)
    }

}
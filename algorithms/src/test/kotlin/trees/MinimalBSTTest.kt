package trees

import com.algorithms.storehouse.logic.tree.MinimalBST
import kotlin.test.Test
import kotlin.test.assertEquals

class MinimalBSTTest {

    @Test
    fun minimalBstTestOddSize() {
        val array = intArrayOf(0, 1, 3, 5, 8, 10, 15, 20, 25)
        val mbst = MinimalBST(array)
        mbst.build()
        val root = mbst.root
        assertEquals(25,root!!.right!!.right!!.right!!.data)
        assertEquals(0, root.left!!.left!!.data)
        assertEquals(10, root.right!!.left!!.data)

    }
}
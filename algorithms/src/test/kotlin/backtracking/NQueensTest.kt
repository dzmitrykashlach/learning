package backtracking

import com.algorithms.storehouse.logic.backtracking.NQueens
import kotlin.test.Test
import kotlin.test.assertEquals

class NQueensTest {

    @Test
    fun nQueensTest0_3() {
        assertEquals(false, NQueens(0).solve(0))
        assertEquals(false, NQueens(1).solve(0))
        assertEquals(false, NQueens(2).solve(0))
        assertEquals(false, NQueens(3).solve(0))
    }

    @Test
    fun nQueensTest4() {
        val nQueens = NQueens(4)
        assertEquals(true, nQueens.solve(0))
    }

    @Test
    fun nQueensTest5() {
        val nQueens = NQueens(5)
        assertEquals(true, nQueens.solve(0))
    }

    @Test
    fun nQueensTest6() {
        val nQueens = NQueens(6)
        assertEquals(true, nQueens.solve(0))
    }
}
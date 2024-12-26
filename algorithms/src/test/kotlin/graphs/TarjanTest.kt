package graphs

import com.algorithms.storehouse.logic.graphs.dfs.scc.tarjan.Tarjan
import com.algorithms.storehouse.entities.graphs.dfs.scc.tarjan.Vertex
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.Test

class TarjanTest {

    @Test
    fun tarjanTest(){
        val one = Vertex("1")
        val two = Vertex("2")
        val three = Vertex("3")
        val four = Vertex("4")
        val five = Vertex("5")
        val six = Vertex("6")
        val seven = Vertex("7")
        val eight = Vertex("8")

        one.adjucencyList.add(two)
        two.adjucencyList.add(six)
        two.adjucencyList.add(five)
        two.adjucencyList.add(three)

        three.adjucencyList.add(four)
        three.adjucencyList.add(seven)

        four.adjucencyList.add(three)
        four.adjucencyList.add(eight)
        five.adjucencyList.add(one)
        five.adjucencyList.add(six)
        six.adjucencyList.add(seven)
        seven.adjucencyList.add(six)
        eight.adjucencyList.add(seven)
        eight.adjucencyList.add(four)
        val vertices = listOf(one,two,three,four,five,six,seven,eight)
        val tarjan = Tarjan()
        tarjan.perform(vertices)
        assertEquals(3,tarjan.scc.size)
        assertEquals(2,tarjan.scc[0]?.size)
        assertTrue(tarjan.scc[0]!!.contains(six))
        assertTrue(tarjan.scc[0]!!.contains(seven))

        assertEquals(3,tarjan.scc[1]?.size)
        assertTrue(tarjan.scc[1]!!.contains(eight))
        assertTrue(tarjan.scc[1]!!.contains(four))
        assertTrue(tarjan.scc[1]!!.contains(three))

        assertEquals(3,tarjan.scc[2]?.size)
        assertTrue(tarjan.scc[2]!!.contains(one))
        assertTrue(tarjan.scc[2]!!.contains(two))
        assertTrue(tarjan.scc[2]!!.contains(five))
    }

    @Test
    fun tarjanTest125(){
        val one = Vertex("1")
        val two = Vertex("2")
        val five = Vertex("5")

        one.adjucencyList.add(two)
        two.adjucencyList.add(five)

        five.adjucencyList.add(one)
        val vertices = listOf(one,two,five)
        val tarjan = Tarjan()
        tarjan.perform(vertices)
        assertEquals(1,tarjan.scc.size)
        assertEquals(3,tarjan.scc[0]?.size)
    }
}
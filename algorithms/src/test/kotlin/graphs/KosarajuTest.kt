package graphs

import com.algorithms.storehouse.logic.graphs.dfs.toposort.Kosaraju
import com.algorithms.storehouse.entities.graphs.dfs.toposort.kosaraju.Vertex
import kotlin.test.assertEquals
import kotlin.test.Test

class KosarajuTest {

    @Test
    fun kosarajuTest() {
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
        val vertices = listOf(one, two, three, four, five, six, seven, eight)

        val kosaraju = Kosaraju()
        kosaraju.perform(vertices)
        assertEquals(3,kosaraju.components.size)
        assertEquals(3,kosaraju.components[1]?.size)
        assertEquals(3,kosaraju.components[2]?.size)
        assertEquals(2,kosaraju.components[3]?.size)
    }
}
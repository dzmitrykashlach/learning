package ya.hr.tech.graphs

import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/search-in-depth
 */

class FindConnectedComponent {
    fun execute(n: Int, edges: List<Pair<Int, Int>>): IntArray {
        // build a adjacency list from list of edges
        val adj = Array(n) { mutableListOf<Int>() }
        edges.forEach {
            adj[it.first].add(it.second)
            adj[it.second].add(it.first)
        }
        val processed = BooleanArray(n) { false }
        val components = IntArray(n) { Int.MIN_VALUE }
        var componentCounter = 0
        for (v in adj.indices) {
            if (!processed[v]) {
                processed[v] = true
                val queue = ArrayDeque<Int>()
                    .also { it.add(v) }
                componentCounter++
                components[v] = componentCounter
                while (queue.isNotEmpty()) {
                    val x = queue.removeFirst()
                    for (u in adj[x]) {
                        if (!processed[u]) {
                            processed[u] = true
                            queue.add(u)
                            components[u] = componentCounter
                        }
                    }
                }
            }
        }
        return components
    }
}

class FindConnectedComponentTest {

    @Test
    fun positive() {

        val edges = listOf(
            4 to 5,
            2 to 2,
            3 to 4,
            2 to 3,
            1 to 3,
            2 to 4
        )
        val components = FindConnectedComponent().execute(6, edges)
        assertEquals(2, components[1])
        assertEquals(2, components[2])
        assertEquals(2, components[3])
        assertEquals(2, components[4])
    }
}
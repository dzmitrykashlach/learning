package ya.hr.tech.graphs

import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/shortest-path-length
 */
class ShortestPath {
    fun pathLength(graph: Array<IntArray>, s: Int, t: Int): Int {
        if (s == t) return 0
        val dist = IntArray(graph.size)
        val visited = BooleanArray(graph.size) { false }
        val queue = ArrayDeque<Int>()
        queue.add(s)
        visited[s] = true
        dist[s] = 0
        while (queue.isNotEmpty()) {
            val v = queue.removeFirst()
            for (u in graph.indices) {
                if (graph[v][u] == 1 && !visited[u]) {
                    visited[u] = true
                    dist[u] = dist[v] + 1
                    if (u == t) {
                        return dist[u]
                    }
                    queue.add(u)
                }
            }
        }
        return Int.MIN_VALUE
    }
}

class ShortestPathTest {

    @Test
    fun pathLengthTest() {
        val graph = arrayOf(
            intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 1, 1, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 0, 0, 0, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 1),
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
        )
        var pathLength = ShortestPath().pathLength(graph, 5, 0)
        assertEquals(3, pathLength)
        pathLength = ShortestPath().pathLength(graph, 4, 3)
        assertEquals(2, pathLength)
    }

}
package com.algorithms.storehouse.logic.graphs.dfs.scc.tarjan

import com.algorithms.storehouse.entities.graphs.dfs.scc.tarjan.Vertex
import java.util.*
import kotlin.collections.HashMap

/*
Implementation guide:
https://www.youtube.com/watch?v=TyWtx7q2D7Y
 */
class Tarjan {
    private val stack = Stack<Vertex>()
    private var index = 0
    private var sccCounter = 0
    val scc: HashMap<Int, LinkedList<Vertex>> = HashMap()

    fun perform(vertices: List<Vertex>) {
        for (vertex in vertices) {
            if (!vertex.visited) {
                dfs(vertex)
            }
        }
    }


    fun dfs(vertex: Vertex) {
        // Set the depth index for v to the smallest unused index
        stack.push(vertex)
        vertex.onStack = true
        vertex.index = index
        vertex.lowLink = index
        vertex.visited = true

        index += 1


        // Consider successors of v
        val neighbors = vertex.adjucencyList
        for (v in neighbors) {
            if (!v.visited) {
                dfs(v)
            }
            if (v.onStack) {
                // Successor w is in stack S and hence in the current SCC
                vertex.lowLink = vertex.lowLink.coerceAtMost(v.lowLink)
            }
        }

        if (vertex.index == vertex.lowLink) {
            scc[sccCounter] = LinkedList()
            while (true) {
                val w = stack.pop()
                w.onStack = false
                w.lowLink = vertex.index
                scc[sccCounter]!!.add(w)
                if (w == vertex) break
            }
            sccCounter += 1
        }
    }
}
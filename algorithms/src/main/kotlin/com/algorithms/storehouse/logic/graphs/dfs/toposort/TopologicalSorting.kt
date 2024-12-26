package com.algorithms.storehouse.logic.graphs.dfs.toposort

import com.algorithms.storehouse.entities.graphs.dfs.toposort.Vertex
import java.util.*

class TopologicalSorting {
    private val stack = Stack<Vertex>()
    fun sort(vertex: Vertex): Stack<Vertex> {
        if (!vertex.visited) {
            dfs(vertex)
            vertex.visited = true
            stack.push(vertex)
        }
        return stack
    }

    private fun dfs(vertex: Vertex) {
        for (v in vertex.adjacencyList) {
            if (!v.visited) {
                dfs(v)
                v.visited = true
                stack.push(v)
            }
        }
    }
}
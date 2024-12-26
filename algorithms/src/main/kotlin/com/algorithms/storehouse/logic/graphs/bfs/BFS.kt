package com.algorithms.storehouse.logic.graphs.bfs

import com.algorithms.storehouse.entities.graphs.Vertex
import java.util.LinkedList

class BFS() {
    var traverse = LinkedList<Vertex>()
    fun perform(vertex: Vertex): MutableList<Vertex> {
        val queue = ArrayDeque<Vertex>()
        queue.addAll(
            vertex.adjucencyList
                .map { it.destination }
        )
        vertex.visited = true
        traverse.add(vertex)
        while (!queue.isEmpty()) {
            val v = queue.removeFirst()
            if (!v.visited) {
                queue.addAll(
                    v.adjucencyList
                        .map { it.destination }
                )
                v.visited = true
                traverse.add(v)
            }
        }
        return traverse
    }
}
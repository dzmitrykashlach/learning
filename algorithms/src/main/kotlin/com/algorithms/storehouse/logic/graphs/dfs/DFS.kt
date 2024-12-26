package com.algorithms.storehouse.logic.graphs.dfs

import com.algorithms.storehouse.entities.graphs.Vertex
import java.util.LinkedList
import java.util.Stack

class DFS {
    val traverse = LinkedList<Vertex>()
    val stack = Stack<Vertex>()

    fun perform(vertex: Vertex): MutableList<Vertex> {
        stack.push(vertex)
        for (e in vertex.adjucencyList) {
            if (!e.destination.visited) {
                stack.push(e.destination)
                dfs(e.destination)
                e.destination.visited = true
                traverse.add(e.destination)
                stack.pop()
            }
        }
        vertex.visited = true
        traverse.add(vertex)
        return traverse
    }

    fun dfs(vertex: Vertex) {
        for (e in vertex.adjucencyList) {
            if (!e.destination.visited) {
                stack.push(e.destination)
                dfs(e.destination)
                e.destination.visited = true
                traverse.add(e.destination)
                stack.pop()
            }
        }
    }
}
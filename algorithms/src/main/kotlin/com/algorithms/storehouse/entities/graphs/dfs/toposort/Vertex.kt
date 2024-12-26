package com.algorithms.storehouse.entities.graphs.dfs.toposort


class Vertex (
    val name: String
) {
    var visited: Boolean = false
    val adjacencyList: MutableList<Vertex> = ArrayList()
    fun addNeighbour(vertex: Vertex) {
        adjacencyList.add(vertex)
    }
}
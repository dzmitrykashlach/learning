package com.algorithms.storehouse.entities.graphs.dfs.toposort.kosaraju


data class Vertex constructor(
    val name: String
) {
    var visited: Boolean = false
    var weight: Int = Int.MAX_VALUE
    var adjucencyList: ArrayList<Vertex> = ArrayList()
}
package com.algorithms.storehouse.entities.graphs.dfs.euleriancycle

data class Edge (
    val from: Int,
    val to: Int,
) {
    var visited = false
}
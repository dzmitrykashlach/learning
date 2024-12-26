package com.algorithms.storehouse.entities.graphs


data class Vertex(
    val id: Int,
    val adjucencyList: MutableList<Edge>,
) {
    var visited: Boolean = false
}
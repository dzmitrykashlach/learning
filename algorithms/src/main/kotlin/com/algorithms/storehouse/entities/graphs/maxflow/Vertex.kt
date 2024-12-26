package com.algorithms.storehouse.entities.graphs.maxflow

import kotlin.collections.ArrayList

data class Vertex (
    val id: Int
) {
    var adjucencyList: List<Edge> = ArrayList()
}
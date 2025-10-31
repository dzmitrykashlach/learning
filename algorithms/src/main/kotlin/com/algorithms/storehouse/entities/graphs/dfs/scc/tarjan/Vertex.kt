package com.algorithms.storehouse.entities.graphs.dfs.scc.tarjan

import java.util.*


data class Vertex(
    val name: String
) {
    var visited = false
    var onStack: Boolean = false
    var index: Int = Int.MAX_VALUE
    var lowLink: Int = Int.MAX_VALUE
    var adjucencyList: ArrayList<Vertex> = ArrayList()
}
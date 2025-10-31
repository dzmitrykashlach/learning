package com.algorithms.storehouse.entities.graphs.mst.prim

class Vertex(
    val name: String
) {
    var visited: Boolean = false
    var weight: Int = Int.MAX_VALUE
    var adjucencyList: HashMap<Vertex,Int> = hashMapOf()
}
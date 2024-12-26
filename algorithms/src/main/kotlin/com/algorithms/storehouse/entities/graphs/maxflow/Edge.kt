package com.algorithms.storehouse.entities.graphs.maxflow

class Edge (
    val from: Vertex,
    val target: Vertex,
    val capacity: Int,
    var flow: Int = 0
) {

    fun oppositeVertex(vertex: Vertex): Vertex {
        return if (vertex == from) target else from
    }

    fun residualCapacity(vertex: Vertex): Int {
        return if (vertex == from)
            flow //forward edge
        else capacity - flow //backward edge
    }

    fun addResidualFlow(vertex: Vertex, deltaFlow: Int) {
        if (vertex == from)
            flow -= deltaFlow // backward edge
        else flow += deltaFlow // forward edge
    }
}
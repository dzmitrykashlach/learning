package com.algorithms.storehouse.logic.graphs.mst.kruskal

import com.algorithms.storehouse.entities.graphs.mst.kruskal.Edge
import com.algorithms.storehouse.entities.graphs.mst.kruskal.Vertex

/*
 Time complexity = O(N)
 */
class Kruskal {
    fun calculate(vertices: MutableList<Vertex>, edges: MutableList<Edge>): Int {
        val verticesLists = HashMap<String, MutableList<Vertex>>()
        for (v: Vertex in vertices) {
            val list: MutableList<Vertex> = mutableListOf(v)
            v.disjointSet = list
            verticesLists.put(v.name, list)
        }
        edges.sort()
        var cost = 0
        var differentSets: Boolean
        for (e: Edge in edges) {
//             check if first and second vertices are in different lists
            val firstVertexList = e.firstVertex.disjointSet as MutableList
            val secondVertexList = e.secondVertex.disjointSet as MutableList


            differentSets = !(firstVertexList.contains(e.secondVertex)
                    || secondVertexList.contains(e.firstVertex))

            if (differentSets && secondVertexList.isNotEmpty() && firstVertexList.isNotEmpty()) {
                secondVertexList
                    .let {
                        firstVertexList.addAll(it)
                        for (v: Vertex in secondVertexList) {
                            v.disjointSet = firstVertexList
                        }
                        verticesLists.remove(e.secondVertex.name)
                        println("$e is added to MST")
                        cost += e.weight
                    }
            }
        }
        return cost
    }
}
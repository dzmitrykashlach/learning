package com.algorithms.storehouse.logic.graphs.dfs.euleriancycle

import com.algorithms.storehouse.entities.graphs.dfs.euleriancycle.Edge
import java.lang.RuntimeException
import java.util.LinkedList

class EulerianCycle (
    val graph: ArrayList<ArrayList<Edge>>,
) {
    val verticesNum: Int = graph.size
    val edgeNum = graph.let {
        var edgeNum = 0
        for (i in it) {
            edgeNum += i.size
        }
        return@let edgeNum

    }
    val inEdges: IntArray = IntArray(graph.size)
    val outEdges: IntArray = IntArray(graph.size)
    val path = LinkedList<Int>()

    fun find(vertex: Int): LinkedList<Int> {
        countInOutDegrees()
        if (!graphHasEulerianPath()) {
            throw RuntimeException("No Eulerian path in the graph")
        }
        dfs(vertex)
        if (path.size == edgeNum + 1) {
            return path
        } else {
            throw RuntimeException("No Eulerian path in the graph")
        }
    }

    fun graphHasEulerianPath(): Boolean {
        var start = 0
        var end = 0
        for (i in 0 until verticesNum) {
            if ((outEdges[i] - inEdges[i] > 0) || (inEdges[i] - outEdges[i]) > 1) {
                return false
            } else if (outEdges[i] - inEdges[i] == 1) {
                start += 1
            } else if (inEdges[i] - outEdges[i] == 1) {
                end += 1
            }
        }
        return (end == 0 && start == 0) || (end == 1 && start == 1)
    }

    fun countInOutDegrees() {
        for (edges in graph) {
            for (edge in edges) {
                outEdges[edge.from] += 1
                inEdges[edge.to] += 1
            }
        }
    }

    fun dfs(vertex: Int) {
//       while current vertex still has unvisited  outgoing edges
        while (outEdges[vertex] != 0) {
//       select the next unvisited outgoing edge
            outEdges[vertex] -= 1
            val nextEdge = graph[vertex].get(outEdges[vertex])
            dfs(nextEdge.to)
        }
//        Add current vertex to path
        path.add(vertex)
    }
}
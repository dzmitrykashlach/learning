package com.algorithms.storehouse.logic.graphs.dfs.toposort

import com.algorithms.storehouse.entities.graphs.dfs.toposort.kosaraju.Vertex
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Kosaraju {
    private val stack = Stack<Vertex>()
    val components: HashMap<Int, LinkedList<Vertex>> = HashMap()
    fun perform(vertices: List<Vertex>) {
//       build topological ordering stack
        topologicalSort(vertices.get(0))
        //reverse adjacency map for every vertex
        val reversedGraph = reverseEdges(vertices)
//       detect strongly connected components
        stronglyConnComp(reversedGraph)

    }

    fun stronglyConnComp(reverseList: List<Vertex>) {
        var compCount = 1
        while (stack.isNotEmpty()) {
            val vertexStack = stack.pop()
            val vertexReverse = reverseList.filter { x -> x.name.equals(vertexStack.name) }.get(0)
            if (!vertexReverse.visited) {
                dfsComponents(vertexReverse, compCount)
                compCount += 1
            }
        }
    }

    fun reverseEdges(vertices: List<Vertex>): List<Vertex> {
        val transposedGraph = ArrayList<Vertex>()
        vertices.forEach { v ->
            transposedGraph.add(v.copy())
        }
        transposedGraph.forEach { x -> x.adjucencyList = ArrayList() }

        for (i in vertices.indices) {
            val vertex = vertices[i]
            val neighbors = vertex.adjucencyList
            for (j in neighbors.indices) {
                val neighInd = transposedGraph.indexOf(neighbors[j])
                transposedGraph[neighInd].adjucencyList.add(transposedGraph[i])
            }
        }
        return transposedGraph
    }

    fun topologicalSort(vertex: Vertex) {
        if (!vertex.visited) {
            dfs(vertex)
            vertex.visited = true
            stack.push(vertex)
        }
        return
    }

    fun dfs(vertex: Vertex) {
        vertex.visited = true
        val neighbors = vertex.adjucencyList
        for (v in neighbors) {
            if (!v.visited) {
                dfs(v)
                v.visited = true
                stack.push(v)
            }
        }
    }

    fun dfsComponents(vertex: Vertex, componentNum: Int) {
        vertex.visited = true
        if (components[componentNum] == null) {
            val component = LinkedList<Vertex>()
            component.add(vertex)
            components[componentNum] = component
        }
        val neighbors = vertex.adjucencyList
        for (v in neighbors) {
            if (!v.visited) {
                dfsComponents(v, componentNum)
                v.visited = true
                components[componentNum]?.add(v)
            }
        }
    }
}
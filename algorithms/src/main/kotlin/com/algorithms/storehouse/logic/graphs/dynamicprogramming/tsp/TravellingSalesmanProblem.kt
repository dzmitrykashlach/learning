package com.algorithms.storehouse.logic.graphs.dynamicprogramming.tsp

import java.util.LinkedList

class TravellingSalesmanProblem(
    val size: Int,
    val graph: Array<IntArray>

) {
    val visited: BooleanArray = BooleanArray(size).also { it[0] = true }
    var path: LinkedList<Int> = LinkedList<Int>().also { it.push(0) }
    var min: Int = Int.MAX_VALUE
    var minPath: LinkedList<Int> = LinkedList<Int>().also { it.push(0) }



    fun solve(actualPosition: Int, cost: Int) {
        // base-case
        // we have considered all the vertices in the G(V,E) graph
        // AND there is a connection between the last and first nodes of the graph
        if (path.size == graph.size && graph[actualPosition][0] != 0) {
            path.push(0)
            if (cost + graph[actualPosition][0] < min) {
                min = cost + graph[actualPosition][0]
                minPath.clear()
                minPath.addAll(path)
            }
//        remove the last node
            path.pop()
            return
        }


        //    we have to consider all the i vertices in the G(V,E)
        /*for(i in graph.indices){

        }*/
        graph.indices.forEach {
            /*
            we're checking that:
            - vertex is not visited;
            - there is connection between current vertex and vertex that we are checking;
            */
            if (valid(it, actualPosition)) {
                visited[it] = true
                path.push(it)
                solve(it, cost + graph[actualPosition][it])
//                backtrack
                visited[it] = false
                path.pop()
            }
        }
    }

    fun valid(vertex: Int, actualPosition: Int): Boolean {
//        if the vertex is already been visited it is not good
        if (visited[vertex]) {
            return false
        }
//        is there a connection between the 2 vertices
        if (graph[actualPosition][vertex] == 0) {
            return false
        }
        return true
    }

}

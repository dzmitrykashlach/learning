package com.algorithms.storehouse.logic.graphs.dfs.toposort

import java.util.*

class ProjectDependencies(
    val graphSize: Int,
    val dependencies: Array<Pair<Int, Int>>
) {
    var subprojects: Array<IntArray> = Array(graphSize) { IntArray(graphSize) { 0 } }.also {
        for (d in dependencies) {
            it[d.first][d.second] = 1
        }
    }
    private val visited = BooleanArray(subprojects.size) { false }
    private val stack = Stack<Int>()
    fun sort(vertex: Int): Stack<Int> {
        if (!visited[vertex]) {
            dfs(vertex)
            visited[vertex] = true
            stack.push(vertex)
        }
        return stack
    }

    private fun dfs(vertex: Int) {
        for (v in 0 until graphSize) {
            if (subprojects[vertex][v] == 1 && (!visited[v])) {
                dfs(v)
                visited[v] = true
                stack.push(v)
            }
        }
        /*for (v in vertex.adjacencyList) {
            if (!v.visited) {
                dfs(v)
                v.visited = true
                stack.push(v)
            }
        }*/
    }
}
package com.algorithms.storehouse.logic.graphs.shortpathkeys

import java.util.*
import kotlin.collections.ArrayDeque


/*
Description
https://leetcode.com/problems/shortest-path-to-get-all-keys/
http://anothercasualcoder.blogspot.com/2018/12/shortest-path-to-get-all-keys-hard.html
https://dzmitrykashlach.github.io/kotlin/2023/07/31/algorithmic-games-shortpath.html
Solution principle:
- path is the sequence of states, not a real-time movement
 */
val keyex = Regex("[a-f]")
val lockex = Regex("[A-F]")
//const val targetKeys = 6

class ShortTestPathAllKeysBFS(
    val grid: Array<CharArray>,
    private val targetKeys: Int
) {
    private var locks: Set<Char> = mutableSetOf()
    private var centralKeyStore: Set<Char> = mutableSetOf()
    private val start = '@'
    private val wall = '#'
    val visited = Hashtable<String, Boolean>()

    fun getPath(start: Pair<Int, Int>): PathState? {
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (lockex.matches(grid[r][c].toString()))
                    locks = locks.plus(grid[r][c])
            }
        }
        //process BFS
        val queue = ArrayDeque<PathState>()

//        we are adding start cell to the queue
        val qi = PathState(start.first, start.second, this.start, LinkedList(), null)
//        each state(row,column,key,movies,previous keys) has its own hash and can be marked as visited
        visited[qi.hashTableKey()] = true
        queue.add(qi)
        var cqi: PathState
        var nextMovies: LinkedList<Pair<Int, Int>>
        while (queue.size > 0) {
            cqi = queue.removeFirst()
//            we collected all keys and can return from method
            if (cqi.keys.size == targetKeys) return cqi
//            helping arrays for iterating over cell neighbours
            val deltaRows = intArrayOf(-1, 1, 0, 0)
            val deltaCols = intArrayOf(0, 0, -1, 1)
//            for every neighbour
            for (i in deltaRows.indices) {
                val nextRow: Int = deltaRows[i] + cqi.row
                val nextColumn: Int = deltaCols[i] + cqi.col
//                if neighbor is valid for moving forward(not a wall, not out-of-bounds)
                if (nextRow >= 0 && nextRow < grid.size && nextColumn >= 0 && nextColumn < grid[0].size && grid[nextRow][nextColumn] != wall) {
//                    create new state
                    nextMovies = LinkedList(cqi.moves)
                    nextMovies.add(Pair(nextRow, nextColumn))
                    val tempKeys = if (centralKeyStore.size < cqi.keys.size)cqi.keys else centralKeyStore
                    val nextState = PathState(
                        nextRow, nextColumn,
                        grid[nextRow][nextColumn],
                        nextMovies,
                        tempKeys
                    )
//                if cell can be passed
                    if (nextState.canPass(grid[nextRow][nextColumn]) && !visited.containsKey(nextState.hashTableKey())) {
                        visited[nextState.hashTableKey()] = true
                        if (centralKeyStore.size < cqi.keys.size) {
                            centralKeyStore = centralKeyStore.plus(cqi.keys)
                            queue.clear()
                        }
                        queue.addLast(nextState)
                    }
                }
            }
        }
        return null
    }


    data class PathState(
        val row: Int, val col: Int,
        val cell: Char, val moves: LinkedList<Pair<Int, Int>>,
        val previousKeys: Set<Char>?,
    ) {
        var keys: Set<Char> = emptySet()

        init {
            if (previousKeys != null) keys = keys.plus(previousKeys)

            // is this working as expected ?
            if (keyex.matches(cell.toString()) && !keys.contains(cell)) {
                keys = keys.plus(cell)
            }
        }

        fun hashTableKey(): String {
            var key = ""
            key += row.toString()
            key += "@"
            key += col.toString()
            key += "@"
            for (k in keys) key += k.toString()
            return key
        }

        fun canPass(l: Char): Boolean {
            if (lockex.matches(l.toString()))
                return keys.contains(l.lowercaseChar())
            return true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as PathState

            if (row != other.row) return false
            if (col != other.col) return false
            if (cell != other.cell) return false
            if (moves != other.moves) return false
            if (previousKeys != other.previousKeys) return false
            return keys.size == other.keys.size
        }

        override fun hashCode(): Int {
            var result = row
            result = 31 * result + col
            result = 31 * result + cell.hashCode()
            result = 31 * result + moves.hashCode()
            result = 31 * result + previousKeys.hashCode()
            return result
        }
    }


}
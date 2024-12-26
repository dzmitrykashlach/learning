package com.algorithms.storehouse.entities.graphs.dfs.toposort.scenario

import java.time.LocalDateTime
import java.util.function.Supplier
import kotlin.random.Random


class Stage(
    val name: String
) : Supplier<String> {
    var visited: Boolean = false
    var done: Boolean = false
    val adjacencyList: MutableList<Stage> = ArrayList()
    val r = Random(PAUSE)
    lateinit var result: String;

    override fun get(): String {
        pause(r.nextLong(1000, 10000))
        println("Stage - $name - is finished at  ${LocalDateTime.now()}")
        result = name
        done = true
        return result
    }

    private fun pause(t: Long) =
        runCatching { Thread.sleep(t) }
            .onFailure { throw it }

    private companion object {
        const val PAUSE = 100L
    }
}
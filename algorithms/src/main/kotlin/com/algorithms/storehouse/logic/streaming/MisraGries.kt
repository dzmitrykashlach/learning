package com.algorithms.storehouse.logic.streaming

import com.algorithms.storehouse.entities.hashmap.LimitedHashMap
import java.util.function.Consumer

/*
https://medium.com/nerd-for-tech/the-streaming-model-and-how-to-estimate-the-most-frequent-elements-with-the-misra-gries-algorithm-c880bbe7218b
 */
class MisraGries {
    fun perform(source: List<Int>): LimitedHashMap<Int, Int> {
        val k = 2
        val summary = LimitedHashMap<Int, Int>(2)
        for (i in source) {
            if (summary.containsKey(i)) {
                summary.replace(i, summary[i]!! + 1)
            } else if (summary.size < k - 1) {
                summary.putKey(i,1)
            } else {
                for (key in summary.keys) {
                    summary.replace(key, summary[key]!! - 1)
                    if (summary[key] == 0) {
                        summary.remove(key)
                    }
                }
            }
        }
        summary.keys.forEach(Consumer { a: Int -> println("key " + a + " -> " + summary[a]) })
        return summary
    }
}
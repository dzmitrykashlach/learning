package com.algorithms.storehouse.logic.streaming.parkingroof

import java.util.*

class ParkingRoof(private val parking: IntArray) {
    fun calculateShortestRoof(numRequiredCars: Int): Optional<MutableMap.MutableEntry<Int, Int>> {
        var minKey = 0
        /*
TreeMap gives O(log) time complexity and do not deprave performance
*/
        val roofCounters = TreeMap<Int, Int>()
        for (i in parking.indices) {
//          increment all values in roofCounters;
            if (parking[i] == 1) {
//                if we got a slot with a car - increase all counters;
                roofCounters.forEach { (key: Int, value: Int) -> roofCounters.replace(key, value + 1) }
                if (roofCounters.containsKey(minKey) && roofCounters.size > 2) {
//                    get higher entry in tree after min key
                    val (key, value) = roofCounters.higherEntry(minKey)
                    //                   if we see that min key counter is obviously less efficient - we remove it
                    if (key - minKey > kotlin.math.abs(value - roofCounters[minKey]!!)) {
                        roofCounters.remove(minKey)
                    }
                }
                //                add counter which will start from current position
                roofCounters[i] = 1
                //                get minimal key - it will be the longest roof;
                minKey = Collections.min(roofCounters.keys)
            }
        }
        val byKeyValue = Comparator.comparing { (key, value): Map.Entry<Int, Int> -> value - key }
        //        return counter which covers at least required number of cars and has minimal number of empty slots under the roof
        return Optional.ofNullable(
            roofCounters.entries.filter { (_, value) -> value >= numRequiredCars }
                .maxWithOrNull(byKeyValue)
        )
    }
}
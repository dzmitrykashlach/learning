package ya.hr.tech.arrays

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/algorithm-training-september-2025/problems/mushroom-sharing
 */
class MushroomsSharing {
    fun joy(mushrooms: IntArray): Int {
        var vasyaTotalWeight = 0
        var vasyaMin = Int.MAX_VALUE
        var mashaTotalWeight = 0
        var mashaMax = Int.MIN_VALUE
        for (m in mushrooms.indices) {
            val weight = mushrooms[m]
            if (m % 2 == 0) {
                vasyaTotalWeight += weight
                if (weight < vasyaMin) {
                    vasyaMin = weight
                }
            } else {
                mashaTotalWeight += weight
                if (weight > mashaMax) {
                    mashaMax = weight
                }
            }
        }
        if (vasyaMin < mashaMax) {
            vasyaTotalWeight += mashaMax - vasyaMin
            mashaTotalWeight += vasyaMin - mashaMax
        }
        return abs(vasyaTotalWeight - mashaTotalWeight)
    }
}


class MushroomsSharingTest {
    @Test
    fun joyTest(){
        var mushrooms = intArrayOf(4, 6, 8, 9, 23, 65, 1, 90, 5, 17)
        assertEquals(32,MushroomsSharing().joy(mushrooms))
        mushrooms = intArrayOf(4, 10, 7, 5, 4, 5, 3, 8, 3, 2, 5)
        assertEquals(10,MushroomsSharing().joy(mushrooms))

    }
}
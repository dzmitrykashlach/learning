package arrays

import com.algorithms.storehouse.logic.arrays.TrappingRainWater
import kotlin.test.Test

class TrappingRainWaterTest {

    @Test
    fun trappingRainWaterTest(){
        val trap = intArrayOf(0, 2, 0, 0, 0, 2)
        val length = trap.size
        println("==================================================")
        println(TrappingRainWater().maxWater(trap, length))
    }
}
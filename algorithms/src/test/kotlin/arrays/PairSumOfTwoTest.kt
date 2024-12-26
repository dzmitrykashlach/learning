package arrays

import com.algorithms.storehouse.logic.arrays.PairsSumOfTwo
import kotlin.test.Test

class PairSumOfTwoTest {

        @Test
        fun pairSumOfTwoTest() {
            val arr = intArrayOf(1, 23, 2, 3, 4, 5, 6, 69, 7, 8, 9, 10)
            val pairs = PairsSumOfTwo().find(arr, 5)
            pairs.forEach { (key: Int, value: Int) -> println("$key -> $value") }
        }
}
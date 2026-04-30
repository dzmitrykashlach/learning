package ya.hr.tech.arrays

import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/sum-of-numbers
 */

class SumOfNumbers {
    fun find(k: Int, numbers: IntArray): Int {
        var counter = 0
        var left = 0
        var sum = 0
        for (right in numbers.indices) {
            sum += numbers[right]
            while (sum > k && left <= right) {
                sum -= numbers[left]
                left++
            }
            if (sum == k) {
                counter++
            }
        }
        return counter
    }
}

class SumOfNumbersTest {
    @Test
    fun findTest() {
        var numbers = intArrayOf(1, 9, 10, 2, 8, 1, 1, 9, 10, 0)
        assertEquals(7, SumOfNumbers().find(10, numbers))
        numbers = intArrayOf(10)
        assertEquals(1, SumOfNumbers().find(10, numbers))
        numbers = intArrayOf(10, 0)
        assertEquals(2, SumOfNumbers().find(10, numbers))
    }
}
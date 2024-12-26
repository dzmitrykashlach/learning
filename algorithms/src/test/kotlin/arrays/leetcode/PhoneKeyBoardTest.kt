package arrays.leetcode

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail
/*
https://www.baeldung.com/cs/k-combinations-recursive-iterative-enumeration
*/
class PhoneKeyBoardTest {

    val combinations = mutableSetOf<MutableList<Char>>()

    @Test
    fun testPhoneKeyboard() {
        phoneCombinations("23")
        assertEquals(9, combinations.size)
        combinations.clear()
        phoneCombinations("89")
        assertEquals(12, combinations.size)
        combinations.clear()

// TODO leading 0 => only 1st 3-4 combinations are correct
   /*     phoneCombinations("08")
        assertEquals(3, combinations.size)
        combinations.clear()
        phoneCombinations("087")*/
// TODO leading 1 => combinations.size = 0
       /* phoneCombinations("1087")
        assertEquals(3, combinations.size)*/
// TODO trailing 0 => ?
        phoneCombinations("890")
        assertEquals(3, combinations.size)
// TODO trailing 1 => 1 is not used

    /*    phoneCombinations("891")
        assertEquals(3, combinations.size)*/

        fail()
    }


    fun phoneCombinations(number: String) {
        val arrays = mutableListOf<CharArray>().also {
            for (s in number) {
                keyboard[s]?.let { it1 -> it.add(it1) }
            }
        }
        for (c in arrays[0]) {
            val combination = mutableListOf(c)
            combination(arrays.subList(1, arrays.size), combination, arrays.size)
        }
        println()
    }

    fun combination(arrays: MutableList<CharArray>, combination: MutableList<Char>, size: Int) {
        if (combination.size == size) {
            combinations.add(combination.toMutableList())
            combination.removeLast()
            return
        }
//        FIXME
        for (c in arrays[0]) {
            combination.add(c)
            combination(arrays.subList(1, arrays.size), combination, size)

        }
    }

    private companion object {
        val keyboard = mapOf(
            '1' to charArrayOf(Char.MIN_VALUE),
            '2' to charArrayOf('a', 'b', 'c'),
            '3' to charArrayOf('d', 'e', 'f'),
            '4' to charArrayOf('g', 'e', 'h'),
            '5' to charArrayOf('j', 'k', 'l'),
            '6' to charArrayOf('m', 'n', 'o'),
            '7' to charArrayOf('p', 'q', 'r', 's'),
            '8' to charArrayOf('t', 'u', 'v'),
            '9' to charArrayOf('w', 'x', 'y', 'z'),
            '0' to charArrayOf('\u00A0')
        )
    }
}
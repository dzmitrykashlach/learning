package stacks

import com.algorithms.storehouse.logic.strings.Integer2Roman
import kotlin.test.assertEquals
import kotlin.test.Test

class Integer2RomanTest {
    // 100 test cases
    @Test
    fun test3421() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCDXLI", integer2Roman.intToRoman(3441))
    }

    @Test
    fun test3521() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMDXXI", integer2Roman.intToRoman(3521))
    }

    @Test
    fun test3721() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMDCCXXI", integer2Roman.intToRoman(3721))
    }

    @Test
    fun test3921() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCMXXI", integer2Roman.intToRoman(3921))
    }

    // 10 test cases
    @Test
    fun test3221() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCCXXI", integer2Roman.intToRoman(3221))
    }

    @Test
    fun test3241() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCCXLI", integer2Roman.intToRoman(3241))
    }

    @Test
    fun test3251() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCCLI", integer2Roman.intToRoman(3251))
    }

    @Test
    fun test3271() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCCLXXI", integer2Roman.intToRoman(3271))
    }

    @Test
    fun test3291() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCCXCI", integer2Roman.intToRoman(3291))
    }

    // 1000 test cases
    @Test
    fun test2131() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMCXXXI", integer2Roman.intToRoman(2131))
    }

    // 1 test cases
    @Test
    fun test2132() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMCXXXII", integer2Roman.intToRoman(2132))
    }

    @Test
    fun test2134() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMCXXXIV", integer2Roman.intToRoman(2134))
    }

    @Test
    fun test2135() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMCXXXV", integer2Roman.intToRoman(2135))
    }

    @Test
    fun test2138() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMCXXXVIII", integer2Roman.intToRoman(2138))
    }

    @Test
    fun test2139() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMCXXXIX", integer2Roman.intToRoman(2139))
    }

    @Test
    fun test3444() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCDXLIV", integer2Roman.intToRoman(3444))
    }

    @Test
    fun test3999() {
        val integer2Roman = Integer2Roman()
        assertEquals("MMMCMXCIX", integer2Roman.intToRoman(3999))
    }
}
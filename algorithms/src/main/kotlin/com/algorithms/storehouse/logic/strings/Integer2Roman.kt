package com.algorithms.storehouse.logic.strings

import java.util.*

class Integer2Roman {
    fun intToRoman(num: Int): String {
        var num = num
        val digits = Stack<Int>()
        //        split int into digits
        var digit:Int
        while (num > 0) {
            digit = num % 10
            digits.push(digit)
            num = num / 10
        }
        val roman = StringBuilder()
        while (!digits.empty()) {
            val position = digits.size
            digit = digits.pop()
            if ((digit >= 1) and (digit < 4)) {
                when (position) {
                    1 -> roman.append(java.lang.String.join("", Collections.nCopies(digit, mapping[0])))
                    2 -> roman.append(java.lang.String.join("", Collections.nCopies(digit, mapping[2])))
                    3 -> roman.append(java.lang.String.join("", Collections.nCopies(digit, mapping[4])))
                    4 -> roman.append(java.lang.String.join("", Collections.nCopies(digit, mapping[6])))
                }
            }
            if (digit == 4) {
                when (position) {
                    1 -> roman.append(java.lang.String.join("", mapping[0], mapping[1]))
                    2 -> roman.append(java.lang.String.join("", mapping[2], mapping[3]))
                    3 -> roman.append(java.lang.String.join("", mapping[4], mapping[5]))
                }
            }
            if (digit == 5) {
                when (position) {
                    1 -> roman.append(mapping[1])
                    2 -> roman.append(mapping[3])
                    3 -> roman.append(mapping[5])
                }
            }
            if ((digit > 5) and (digit < 9)) {
                when (position) {
                    1 -> roman.append(mapping[1])
                        .append(java.lang.String.join("", Collections.nCopies(digit - 5, mapping[0])))

                    2 -> roman.append(mapping[3])
                        .append(java.lang.String.join("", Collections.nCopies(digit - 5, mapping[2])))

                    3 -> roman.append(mapping[5])
                        .append(java.lang.String.join("", Collections.nCopies(digit - 5, mapping[4])))
                }
            }
            if (digit == 9) {
                when (position) {
                    1 -> roman.append(java.lang.String.join("", mapping[0], mapping[2]))
                    2 -> roman.append(java.lang.String.join("", mapping[2], mapping[4]))
                    3 -> roman.append(java.lang.String.join("", mapping[4], mapping[6]))
                }
            }
        }
        return roman.toString()
    }

    companion object {
        private val mapping: MutableList<String> = ArrayList()

        init {
            mapping.add("I") // 1
            mapping.add("V") // 5
            mapping.add("X") // 10
            mapping.add("L") // 50
            mapping.add("C") // 100
            mapping.add("D") // 500
            mapping.add("M") // 1000
        }
    }
}
package com.algorithms.storehouse.logic.strings

class Pangram {
    fun isPangram(pangram: List<String>): String {
        var isPangram = true
        var c = 'a'
        while (c <= 'z') {
            for (s in pangram) {
                if (s.indexOf(c) == -1) {
                    isPangram = false
                    break
                }
            }
            ++c
        }
        return if (isPangram) "1" else "0"
    }
}
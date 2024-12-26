package com.algorithms.storehouse.logic.math

import kotlin.math.abs

class Limit(val f: (Double) -> Double) {

    fun calculate(from: Double, to: Double, accuracy: Double): Double {
        var x = from
            while (abs(f(x) - f((x + to) / 2)) >= accuracy) {
                x = (x + to) / 2
            }
        return f(x)
    }
}
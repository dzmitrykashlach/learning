package com.algorithms.storehouse.logic.math

class Integral(val f: (Double) -> Double) {
    fun calculate(
        a: Double, b: Int,
        delta: Double
    ): Double {
        var i: Double = a
        var integral = 0.0
        while (b >= i) {
            integral += 0.5 * (
                    (f)(i) + (f)((i + delta))
                    ) * delta
            i += delta
        }
        return integral
    }
}
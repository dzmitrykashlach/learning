package math

import com.algorithms.storehouse.logic.math.Integral
import kotlin.test.Test
import kotlin.math.pow
import kotlin.test.assertEquals
/*
 For testing functions:
    https://ru.symbolab.com/solver/definite-integral-calculator
 */
class IntegralTest {

    @Test
    fun `0,1-6`() {
        /*
            4(x^3+2)/x^2
            [a,b] = [0.1,6]
            result = 150.64...
        */
        val f = fun(x: Double) = (4 * (x.pow(3) + 2)) / x.pow(2)
        val integral = Integral(f).calculate(
            0.1, 6, 0.0001
        )
        assertEquals("150.649",String.format("%.3f", integral))
    }

    @Test
    fun `3-5`() {
        /*
            4x/(2-8x^2)
            [a,b] = [0.1,6]
            result = -0.25994...
        */
        val f = fun(x: Double) = (4 * x / (2-8*x.pow(2)))
        val integral = Integral(f).calculate(
            3.0, 5, 0.0001
        )
        assertEquals("-0.259953",String.format("%.6f", integral))
    }
}
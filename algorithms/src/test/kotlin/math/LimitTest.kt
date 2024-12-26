package math

import com.algorithms.storehouse.logic.math.Limit
import kotlin.test.Test
import java.math.BigDecimal
import kotlin.math.pow
import kotlin.test.assertEquals

class LimitTest {

    @Test
    fun `0-2`() {
        val f = fun(x: Double) = 2 * (8 - 2 * x.pow(2)) / (x.pow(2) - 4 * x - 12)
        assertEquals(
            "-0.00000011920928599806768",
            BigDecimal.valueOf(Limit(f).calculate(0.0, 2.0, 0.0000001)).toPlainString()
        )
    }

    @Test
    fun `0-3`() {
        val f = fun(x: Double) = (82 * x.pow(2) - 3) / (10 * x - 5 * x.pow(2))
        assertEquals(
            "-49.00000001136213",
            BigDecimal.valueOf(Limit(f).calculate(0.0, 3.0, 0.00000001)).toPlainString()
        )
    }

    @Test
    fun `2-0`() {
        val f = fun(x: Double) = 1 / x
        assertEquals(
            "Infinity",
            Limit(f).calculate(2.0, 0.0, 0.000001).toString()
        )
    }
}
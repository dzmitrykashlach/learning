package arrays.yandex

import kotlin.test.Test
import kotlin.test.assertEquals

class MaximizeProfit {

    //    https://coderun.yandex.ru/selections/backend/problems/trading-ya-intern
    fun maximizeProfit(sellers: ArrayList<Int>, buyers: ArrayList<Int>): Int {
        val sortedSellers = sellers.sorted()
        val sortedBuyers = buyers.sortedDescending()
        var sellTotalSum = 0
        var buyTotalSum = 0
        for (i in sortedSellers.indices) {
            if (sortedBuyers.size - 1 >= i) {
                sellTotalSum = sellTotalSum.plus(sortedSellers[i])
                buyTotalSum = buyTotalSum.plus(sortedBuyers[i])
            }
        }
        return buyTotalSum - sellTotalSum
    }

    @Test
    fun maximizeProfitTest() {
        assertEquals(
            42, MaximizeProfit()
                .maximizeProfit(
                    arrayListOf(3, 6, 1, 2, 7),
                    arrayListOf(20, 5, 8, 10, 4, 18)
                )
        )
    }
}
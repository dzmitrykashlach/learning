package dynamicprogramming
import com.algorithms.storehouse.logic.dynamicprogramming.HouseRobber
import kotlin.test.Test
import kotlin.test.assertEquals

class HouseRobberTest {

    @Test
    fun bottomUpTest(){
        val houses = intArrayOf(6,7,1,30,8,2,4)
        assertEquals(41, HouseRobber().calculate(houses,0))
    }
}
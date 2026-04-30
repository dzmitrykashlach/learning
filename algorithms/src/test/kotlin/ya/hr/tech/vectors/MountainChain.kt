package ya.hr.tech.vectors

import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/tourism
 */

class MountainChain {
    fun calcAscent(vertices: Array<Pair<Int, Int>>, start: Int, finish: Int): Int {
        var ascent = 0
        for (v in start - 1..finish - 1) {
            if (vertices[v].second < vertices[v + 1].second && v + 1 < finish) {
                ascent = ascent.plus(vertices[v + 1].second - vertices[v].second)
            }
        }
        return ascent
    }
}

class MountainChainTest {

    @Test
    fun calcAscentTest() {
        val mountainChain = arrayOf(
            2 to 1,
            4 to 5,
            7 to 4,
            8 to 2,
            9 to 6,
            11 to 3,
            15 to 3,
        )
        assertEquals(4, MountainChain().calcAscent(mountainChain, 2, 6))
    }
}
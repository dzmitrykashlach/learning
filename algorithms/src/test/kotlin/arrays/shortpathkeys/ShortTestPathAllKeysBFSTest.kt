package arrays.shortpathkeys

import com.algorithms.storehouse.logic.graphs.shortpathkeys.ShortTestPathAllKeysBFS
import kotlin.test.Test
import kotlin.test.assertTrue

class ShortTestPathAllKeysBFSTest {

    @Test
    fun getPathTest_oneWay() {
        val grid = arrayOf(
            "@.a..".toCharArray(),
            "###.#".toCharArray(),
            "b.A.B".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 2)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 8)
    }

    @Test
    fun getPathTest_twoWays() {
        val grid = arrayOf(
            "@..aA".toCharArray(),
            "..B#.".toCharArray(),
            "....b".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 2)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 6)
    }

    @Test
    fun getPathTest_2keys() {
        val grid = arrayOf(
            "@..aA".toCharArray(),
            "..B#b".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 2)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 5)
    }

    @Test
    fun getPathTest_4keys_free_ride() {
        val grid = arrayOf(
            "@..BAС".toCharArray(),
            "...#Dd".toCharArray(),
            "...###".toCharArray(),
            ".....с".toCharArray(),
            "......".toCharArray(),
            "a....b".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 3)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 22)
    }

    @Test
    fun getPathTest_4keys_free_ride_center() {
        val grid = arrayOf(
            "@........BAC".toCharArray(),
            ".........#Dd".toCharArray(),
            ".........###".toCharArray(),
            ".....c......".toCharArray(),
            "............".toCharArray(),
            "a..........b".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 4)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 32)
        assertTrue(path.keys.size == 4)

    }

    @Test
    fun getPathTest_4keys_fixed_way() {
        val grid = arrayOf(
            "@..BAC".toCharArray(),
            ".#.#Dd".toCharArray(),
            ".#.###".toCharArray(),
            ".#.#.c".toCharArray(),
            ".#.#.#".toCharArray(),
            "a#...b".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 4)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 38)
        assertTrue(path.keys.size == 4)
    }

    @Test
    fun getPathTest_4keys_1() {
        val grid = arrayOf(
            "@..aA".toCharArray(),
            "...#C".toCharArray(),
            "...#d".toCharArray(),
            "...#D".toCharArray(),
            "...#c".toCharArray(),
            "..b.B".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 4)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 24)
        assertTrue(path.keys.size == 4)
    }

    @Test
    fun getPathTest_5keys() {
        val grid = arrayOf(
            "@..aA.......Bc.".toCharArray(),
            "............###".toCharArray(),
            "............###".toCharArray(),
            "b............De".toCharArray(),
            "......#.##..###".toCharArray(),
            "......#Cd#....E".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 5)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 41)
        assertTrue(path.keys.size == 5)
    }

    @Test
    fun getPathTest_6keys() {
        val grid = arrayOf(
            "@aAbBcCdDeEf".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 6)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 11)
        assertTrue(path.keys.size == 6)
    }

    @Test
    fun getPathTest_6keys_noWay() {
        val grid = arrayOf(
            "@aAbBcCDdeEf".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 3)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 5)
        assertTrue(path.keys.size == 3)
    }

    @Test
    fun getPathTest_noWay() {
        val grid = arrayOf(
            "@Aa".toCharArray()
        )
        val skpt = ShortTestPathAllKeysBFS(grid, 0)
        val path = skpt.getPath(Pair(0, 0))
        assertTrue(path!!.moves.size == 0)
        assertTrue(path.keys.isEmpty())
    }
}
package arrays

import com.algorithms.storehouse.logic.arrays.WordSearch
import kotlin.test.Test

class WordSearchTest {

    @Test
    fun wordSearchTest(){
        val grid = arrayOf(
            charArrayOf('W', 'E', 'V', 'K', 'T', 'F', 'O', 'R', 'G', 'N', 'E', 'K', 'S'),
            charArrayOf('G', 'Z', 'E', 'Y', 'R', 'A', 'N', 'G', 'E', 'R', 'E', 'Q', 'K'),
            charArrayOf('R', 'E', 'G', 'N', 'S', 'D', 'O', 'N', 'G', 'E', 'R', 'V', 'G')
        )
        val wordSearch = WordSearch(grid.size, grid[0].size)
        wordSearch.wordSearch(grid, "DANGER")
    }
}
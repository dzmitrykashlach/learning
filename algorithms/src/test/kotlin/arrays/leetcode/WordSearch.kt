package arrays.leetcode

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordSearch {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size
        var exists = false

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (exists) break
                if (word[0].equals(board[i][j])) {
                    if (i - 1 >= 0) {
                        exists = bfs(board, i - 1, j, word.substring(1))
                    }
                    if (i + 1 <= m) {
                        exists = bfs(board, i + 1, j, word.substring(1))
                    }
                    if (j - 1 >= 0) {
                        exists = bfs(board, i, j - 1, word.substring(1))
                    }
                    if (j + 1 <= n) {
                        exists = bfs(board, i, j + 1, word.substring(1))
                    }
                }
            }
        }
        return exists
    }

    fun bfs(board: Array<CharArray>, i: Int, j: Int, word: String): Boolean {

        val m = board.size
        val n = board[0].size
        var subWord = word.substring(1)
        if (subWord.length == 1) {
            return true
        }

        if (i - 1 >= 0 && subWord[0].equals(board[i - 1][j])) {
            return bfs(board, i - 1, j, word.substring(1))
        }

        if (i + 1 < m && j < n && subWord[0].equals(board[i + 1][j])) {
            return bfs(board, i + 1, j, word.substring(1))
        }

        if (j - 1 >= 0 && subWord[0].equals(board[i][j - 1])) {
            return bfs(board, i, j - 1, word.substring(1))
        }

        if (j + 1 < n && i < m && subWord[0].equals(board[i][j + 1])) {
            return bfs(board, i, j + 1, word.substring(1))
        }

        return false
    }


    @Test
    fun `abcced - true`() {
        val board = arrayOf(
            charArrayOf('a', 'b', 'c', 'e'),
            charArrayOf('s', 'f', 'c', 's'),
            charArrayOf('a', 'd', 'e', 'e'),
        )
        val exists = WordSearch().exist(board, "abcced")
        assertTrue { exists }
    }

    @Test
    fun `abfdexszyc - true`() {
        val board = arrayOf(
            charArrayOf('a', 'b', 'y', 'z'),
            charArrayOf('s', 'f', 'c', 's'),
            charArrayOf('a', 'd', 'e', 'x'),
            charArrayOf('a', 'd', 'e', 'e'),
            charArrayOf('a', 'd', 'e', 'e'),
        )
        val exists = WordSearch().exist(board, "abfdexszyc")
        assertTrue { exists }
    }
    @Test
    fun `abfdexszyc - false`() {
        val board = arrayOf(
            charArrayOf('a', 'b', 'y', 'q'),
            charArrayOf('s', 'f', 'c', 's'),
            charArrayOf('a', 'd', 'e', 'x'),
            charArrayOf('a', 'd', 'e', 'e'),
            charArrayOf('a', 'd', 'e', 'e'),
        )
        val exists = WordSearch().exist(board, "abfdexszyc")
        assertFalse { exists }
    }
}
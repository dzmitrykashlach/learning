package dynamicprogramming.lcs


class LongestCommonSubsequenceMemoization constructor(
    private val s1: String,
    private val s2: String,
    private val memoization: Array<Array<String>> = Array(s1.length) { Array(s2.length) { "" } }
) {

    fun lcs(index1: Int, index2: Int): String {
        if (index1 == s1.length || index2 == s2.length) {
            return ""
        }
        return if (s1[index1] == s2[index2]) {
            if (memoization[index1][index2] == "") {
                memoization[index1][index2] =
                    s1[index1] + lcs(index1 + 1, index2 + 1)
            }
            memoization[index1][index2]
        } else {
            if (memoization[index1][index2] == "") {
                val op1 = lcs(index1, index2 + 1)
                val op2 = lcs(index1 + 1, index2)
                if (op1.length > op2.length) {
                    memoization[index1][index2] = op1
                } else {
                    memoization[index1][index2] = op2
                }

            }
            memoization[index1][index2]
        }
    }
}
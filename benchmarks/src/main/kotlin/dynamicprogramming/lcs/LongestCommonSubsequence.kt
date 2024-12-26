package dynamicprogramming.lcs


class LongestCommonSubsequence constructor(
    private val s1:String,
    private val s2:String,
){

    fun lcs(index1: Int, index2: Int): String {
        if (index1 == s1.length || index2 == s2.length) {
            return ""
        }
        return if (s1[index1] == s2[index2]) {
                    s1[index1] + lcs(index1 + 1, index2 + 1)
        } else {
            val op1 = lcs(index1, index2 + 1)
            val op2 = lcs(index1 + 1, index2)
            if (op1.length > op2.length) {
                op1
            } else {
                op2
            }
        }
    }
}
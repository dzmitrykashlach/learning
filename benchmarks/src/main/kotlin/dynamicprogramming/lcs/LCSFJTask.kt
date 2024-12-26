package dynamicprogramming.lcs

import java.util.concurrent.RecursiveTask



class LCSFJTask constructor(
    val s1: String,
    val s2: String,
    val index1: Int,
    val index2: Int
) : RecursiveTask<String>() {
    override fun compute(): String {
        if (index1 == s1.length || index2 == s2.length) {
            return ""
        }
        return if (s1[index1] == s2[index2]) {
            val lcs = LCSFJTask(s1, s2, index1 + 1, index2 + 1)
            s1[index1] + lcs.compute()
        } else {
            val op1 =
                if (index1 == 0) {
                    LCSFJTask(s1, s2, index1, index2 + 1).compute()

                } else {
                    LCSFJTask(s1, s2, index1, index2 + 1).compute()
                }
            val op2 = LCSFJTask(s1, s2, index1 + 1, index2).compute()

            if (op1.length > op2.length) {
                op1
            } else {
                op2
            }
        }
    }

}

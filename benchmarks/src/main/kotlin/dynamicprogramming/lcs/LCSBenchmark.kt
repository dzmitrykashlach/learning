package dynamicprogramming.lcs

import org.openjdk.jmh.annotations.*
import java.lang.RuntimeException
import java.util.concurrent.*

@State(Scope.Benchmark)
class LCSBenchmark {

    @Benchmark
    fun lcsBenchmark20characters() {
        val s1 = "q!^@elegphan]*)ty+/y"
        val s2 = "y|ze!res%#patp[=q"
        val lcs = LongestCommonSubsequence(s1, s2)
        val result = lcs.lcs(0, 0)
        if (result != "eepat") {
            throw RuntimeException("Method returned result which is not expected ->$result")
        }
    }

    @Benchmark
    fun lcsMemoBenchmark20characters() {
        val s1 = "q!^@elegphan]*)ty+/y"
        val s2 = "y|ze!res%#patp[=q"
        val lcs = LongestCommonSubsequenceMemoization(s1, s2)
        val result = lcs.lcs(0, 0)
        if (result != "eepat") {
            throw RuntimeException("Method returned result which is not expected ->$result")
        }
    }


    /*
    Plain recursion running time ~13min
   */
    @Benchmark
    fun lcsMemoBenchmark100characters() {
        val s1 = "YegAnSjyele4AUq8wFtJRshmBk06N0dlYDQL3NlZkOhh1Ue6TCIWTjEKUPdaic5wI0sB81CCmFrphantxNdQvoLuhdW9rg02N9liIIzAqwHY"
        val s2 = "sD6r7xbael2qKB8dZeig2M2FmbE8Ghi1tXQFEpCuBnmpreU5po3vDBdipGWtAHGpTwP0EEnGxtLxVcrsigqvZxnIgWtSpat8yDf63ds7"
        val lcs = LongestCommonSubsequenceMemoization(s1,s2)
        val result = lcs.lcs(0,0)
        if (result != "elqBdZei81CmrpodW0iq") {
            throw RuntimeException("Method returned result which is not expected ->$result")
        }
    }


    @Benchmark
    fun lcsBenchmark20characterFJ() {
        val s1 = "GKeleh1bNHY4mfXphant"
        val s2 = "eTPWlrel5SzEDMvpatpl"
        val leftS1 = s1.substring(0, s1.length / 2+1)
        val leftS2 = s2.substring(0, s2.length / 2+1)
        val rightS1 = s1.substring(leftS1.length-1,s1.length)
        val rightS2 = s2.substring(leftS2.length-1,s2.length)
        val fj = ForkJoinPool(2)
        val left = LCSFJTask(leftS1, leftS2, 0, 0)
        val right = LCSFJTask(rightS1, rightS2, 0, 0)
        left.fork()
        right.fork()
        val r1 = fj.submit(left).get()
        val r2 = fj.submit(right).get()
        val result = r1+r2
        if (result != "elepat") {
            throw RuntimeException("Method returned result which is not expected ->$result")
        }
    }
}





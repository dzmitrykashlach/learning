package bitwise

import org.openjdk.jmh.annotations.*


@State(Scope.Benchmark)
class BitwiseBenchMark {
    @Param("100000", "10000000")
    var power = 0


    @Benchmark
    fun pow2(){
        var result = 1
        for (i in 1..power){
            result *= 2
        }
    }

    @Benchmark
    fun pow2Math(){
        Math.pow(2.0,power.toDouble())
    }


    @Benchmark
    fun pow2bitwise(){
//        This line equals 2^power
        1 shl power
    }
}





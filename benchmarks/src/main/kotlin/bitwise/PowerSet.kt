package bitwise

class PowerSet(
    val set: IntArray,
) {
    val subSets = mutableListOf<IntArray>()

    fun generateRecursive(at: Int, used: BooleanArray) {
        val n = set.size
        val range = set.indices
        if (at == n) {

            // Print found subset!
            var subSet = IntArray(n)
            for (i in range) {
                if (used[i]) {
                    subSet[i] = set[i]
                }
            }
            subSets.add(subSet)
        } else {

            // Include this element
            used[at] = true
            generateRecursive(at + 1, used)

            // Backtrack and don't include this element
            used[at] = false
            generateRecursive(at + 1, used)
        }
    }

    fun generateBinary() {
        val n = set.size
        val range = set.indices
        val maxVal = 1 shl n

        for (subset in 0 until maxVal) {
            var subSet = IntArray(n)
            for (i in range) {
                val mask = 1 shl i
                if ((subset and mask) == mask) {
                    subSet[i] = set[i]
                }
            }
            subSets.add(subSet)
        }
    }

}
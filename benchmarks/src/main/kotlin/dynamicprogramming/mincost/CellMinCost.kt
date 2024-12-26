package dynamicprogramming.mincost

class CellMinCost(
    private val cost: Array<IntArray>,
) {

    fun minCost(row: Int, coloumn: Int): Int {
        if (row == -1 || coloumn == -1) {
            return Int.MAX_VALUE
        }
        if (row == 0 && coloumn == 0) {
            return cost[row][coloumn]
        }
        val op1 = minCost(row - 1, coloumn)
        val op2 = minCost(row, coloumn - 1)
        return cost[row][coloumn] + op1.coerceAtMost(op2)
    }
}
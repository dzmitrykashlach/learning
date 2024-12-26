package dynamicprogramming.mincost

class CellMinCostMemoization(
    private val cost: Array<IntArray>,
    val memoization: Array<IntArray> = Array(cost.size) { IntArray(cost[0].size) { 0 } }
) {

    fun minCost(row: Int, coloumn: Int): Int {
        if (row == -1 || coloumn == -1) {
            return Int.MAX_VALUE
        }
        if (row == 0 && coloumn == 0) {
            return cost[row][coloumn]
        }
        if (memoization[row][coloumn] == 0) {
            val op1 = minCost(row - 1, coloumn)
            val op2 = minCost(row, coloumn - 1)
            memoization[row][coloumn] = cost[row][coloumn] + op1.coerceAtMost(op2)
        }
        return memoization[row][coloumn]
    }
}
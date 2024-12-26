package com.algorithms.storehouse.logic.arrays

class PerfectRectangle {

    /*
       Time complexity O(N^3)
     */
    fun isPerfect(rectangles: ArrayList<Rectangle>): Boolean {
        val xMin = rectangles.minWith(Comparator.comparingInt { it.start.first }).start.first
        val xMax = rectangles.maxWith(Comparator.comparingInt { it.end.first }).end.first
        val yMin = rectangles.minWith(Comparator.comparingInt { it.start.second }).start.second
        val yMax = rectangles.maxWith(Comparator.comparingInt { it.end.second }).end.second
        var xOverlap = false
        var yOverlap = false

        for (r in rectangles) {
            var rectanglesMinusOne = rectangles.minusElement(r)
            if (!r.checkXaxis(rectanglesMinusOne, xMin, xMax)) {
                if (!r.checkYaxis(rectanglesMinusOne, yMin, yMax)) {
                    return false
                }
            }
            //          check that rectangles do not overlap
            for (n in rectanglesMinusOne) {
                if (r.end.first > n.start.first && r.start.first < n.end.first) {
                    xOverlap = true
                    if (r.end.second > n.start.second && r.start.second < n.end.second) {
                        yOverlap = true
                    }
                }
            }
            if (xOverlap && yOverlap) {
                return false
            }

        }
        return true
    }


    class Rectangle(
        val start: Pair<Int, Int>,
        val end: Pair<Int, Int>
    ) {

        //            neighbors should have at least one member with end.first = r.start.first
        fun checkXaxis(neighbors: List<Rectangle>, xMin: Int, xMax: Int): Boolean {
            var hasLeft = false
            var hasRight = false
            if (xMin >= xMax) {
                throw RuntimeException("xMin and xMax are invalid")
            }
            if (start.first < xMin || end.first > xMax) {
                throw RuntimeException("start point has invalid coordinates")
            }

            if (start.first >= xMin) {
//                check that there is right neighbour
                for (n in neighbors) {
                    if (n.start.first == end.first) {
                        hasRight = true
                    }
                }
            }
            if (start.first <= xMax) {
//                check that there is left neighbour
                for (n in neighbors) {
                    if (n.end.first == start.first) {
                        hasLeft = true
                    }
                }
            }

//          check combinations of hasLeft&Right and max & min
            if (hasLeft && end.first == xMax) {
                return true
            }
            if (hasRight && start.first == xMin) {
                return true
            }
            return hasLeft && hasRight
        }

        fun checkYaxis(neighbors: List<Rectangle>, yMin: Int, yMax: Int): Boolean {
            var hasBottom = false
            var hasUpper = false
            if (yMin >= yMax) {
                throw RuntimeException("yMin and yMax are invalid")
            }
            if (start.second < yMin || end.second > yMax) {
                throw RuntimeException("start point has invalid coordinates")
            }

            if (start.second >= yMin) {
//                check that there is right neighbour
                for (n in neighbors) {
                    if (n.start.second == end.second) {
                        hasUpper = true
                    }
                }
            }
            if (start.second <= yMax) {
//                check that there is left neighbour
                for (n in neighbors) {
                    if (n.end.second == start.second) {
                        hasBottom = true
                    }
                }
            }

//          check combinations of hasLeft&Right and max & min
            if (hasBottom && end.second == yMax) {
                return true
            }
            if (hasUpper && start.first == yMin) {
                return true
            }
//          rectangle is somewhere in the middle between top and bottom
            return hasBottom && hasUpper
        }
    }
}
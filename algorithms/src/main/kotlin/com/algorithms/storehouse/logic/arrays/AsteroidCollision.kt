package com.algorithms.storehouse.logic.arrays

import java.util.*

class AsteroidCollision(private val asteroids: IntArray) {
    fun resolveCollisions(): IntArray {
        val res = Stack<Int>()
        for (a in asteroids) {
            if (a > 0) {
                res.push(a) //never collide with any in the stack
            } else {
                //check collision with all Positive asteroids that have higher asb value from the right
                while (!res.empty() && res.peek() > 0 && res.peek() < kotlin.math.abs(a)) {
                    res.pop() //destroy all a* < a
                }
                //Add a if (A has max abs or empty stack or last element is neg)
                if (res.empty() || res.peek() < 0) {
                    res.push(a)
                } else if (res.peek() == kotlin.math.abs(a)) {
                    res.pop()
                }
            }
        }
        return res.map { it }.toIntArray() //convert stack to int[]
    }
}
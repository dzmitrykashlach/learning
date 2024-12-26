package arrays

import com.algorithms.storehouse.logic.arrays.AsteroidCollision
import kotlin.test.Test
import kotlin.test.assertEquals
import java.util.*

class AsteroidCollisionTest {
    @Test
    fun asteroidCollisionTest() {
        var input = intArrayOf(5, 10, -5)
        var collision = AsteroidCollision(input)
        assertEquals("[5, 10]", Arrays.toString(collision.resolveCollisions()))
        input = intArrayOf(8, -8)
        collision = AsteroidCollision(input)
        assertEquals("[]", Arrays.toString(collision.resolveCollisions()))
        input = intArrayOf(10, 2, -5)
        collision = AsteroidCollision(input)
        assertEquals("[10]", Arrays.toString(collision.resolveCollisions()))
        input = intArrayOf(-2, -1, 1, 2)
        collision = AsteroidCollision(input)
        assertEquals("[-2, -1, 1, 2]", Arrays.toString(collision.resolveCollisions()))
    }
}
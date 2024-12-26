package graphs

import com.algorithms.storehouse.logic.graphs.dfs.toposort.ProjectDependencies
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ProjectDependenciesTest {

    @Test
    fun projectDependenciesTest_10_vertices() {
        val dependencies = arrayOf(
            Pair(0, 1), Pair(1, 2), Pair(0, 2), Pair(3, 4),
            Pair(1, 3), Pair(4, 5), Pair(0, 5), Pair(7, 8),
            Pair(8, 9), Pair(6, 9), Pair(2, 8), Pair(3, 7),
            Pair(7, 6)
        )
        val pdps = ProjectDependencies(10, dependencies)
        val flow = pdps.sort(0)
        assertEquals(10, flow.size)
        assertEquals(0, flow.pop())
        assertEquals(1, flow.pop())
        assertEquals(3, flow.pop())
        assertEquals(7, flow.pop())
        assertEquals(6, flow.pop())
        assertEquals(4, flow.pop())
        assertEquals(5, flow.pop())
        assertEquals(2, flow.pop())
        assertEquals(8, flow.pop())
        assertEquals(9, flow.pop())


    }

    @Test
    fun projectDependenciesTest_10_vertices_circularDep() {
        val dependencies = arrayOf(
            Pair(0, 1), Pair(1, 2), Pair(0, 2), Pair(3, 4),
            Pair(1, 3), Pair(4, 5), Pair(0, 5), Pair(7, 8),
            Pair(8, 9), Pair(6, 9), Pair(2, 8), Pair(3, 7),
            Pair(7, 6),
            Pair(9, 0)
        )
        val pdps = ProjectDependencies(10, dependencies)
        assertFailsWith<StackOverflowError> {
            pdps.sort(0)
        }
    }

    @Test
    fun projectDependenciesTest_4_vertices() {
        val dependencies = arrayOf(
            Pair(0, 2), Pair(0, 1), Pair(2, 3), Pair(2, 1),
            Pair(0, 3), Pair(1, 3)
        )
        val pdps = ProjectDependencies(4, dependencies)
        val flow = pdps.sort(0)
        assertEquals(4, flow.size)
        assertEquals(0, flow.pop())
        assertEquals(2, flow.pop())
        assertEquals(1, flow.pop())
        assertEquals(3, flow.pop())
    }

    @Test
    fun projectDependenciesTest_5_vertices() {
        val dependencies = arrayOf(
            Pair(0, 2), Pair(0, 1), Pair(2, 3), Pair(2, 1),
            Pair(0, 3), Pair(1, 3), Pair(3, 4), Pair(2, 4)
        )
        val pdps = ProjectDependencies(5, dependencies)
        val flow = pdps.sort(0)
        assertEquals(5, flow.size)
        assertEquals(0, flow.pop())
        assertEquals(2, flow.pop())
        assertEquals(1, flow.pop())
        assertEquals(3, flow.pop())
        assertEquals(4, flow.pop())
    }

    @Test
    fun projectDependenciesTest_7_vertices() {
        val dependencies = arrayOf(
            Pair(0, 2), Pair(0, 6), Pair(0, 1), Pair(2, 3),
            Pair(2, 1), Pair(3, 4), Pair(4, 5), Pair(6, 4),
            Pair(1, 6)
        )
        val pdps = ProjectDependencies(7, dependencies)
        val flow = pdps.sort(0)
        assertEquals(7, flow.size)
        assertEquals(0, flow.pop())
        assertEquals(2, flow.pop())
        assertEquals(3, flow.pop())
        assertEquals(1, flow.pop())
        assertEquals(6, flow.pop())
        assertEquals(4, flow.pop())
        assertEquals(5, flow.pop())
        /*
                expected: 0 2 3 1 6 4 5

        */
    }
}
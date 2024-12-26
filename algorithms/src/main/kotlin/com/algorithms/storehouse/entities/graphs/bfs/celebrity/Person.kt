package com.algorithms.storehouse.entities.graphs.bfs.celebrity

/*
This challenge has been provided to candidates during Amazon interview process.
There is a group of K persons. This persons may know each other, not necessarily mutually
There is a celebrity among them.
Celebrity is a person which is known by everybody, but he doesn't know anybody.
Initially we do not know who knows whom, but we can ask every person if he knows other people from group.
We need to identify celebrity with minimum amount of questions;

Solution:
Let's consider a group of people as a graph, where person is a vertex, and if
one person knows another - it's an edge. E.g. we need to identify vertex which
doesn't have any outgoing edges. For this purpose we'll use BFS approach.
Time complexity = O(N), N = max number of persons who are known by any
member of group. E.g. if anybody knows 6/10, then with 6 questions(worst case)
celebrity will be identified.
*/

class Person (val name: String) {
    val knows: MutableSet<Person> = HashSet()
    var isAsked = false
    fun findCelebrityBFS(): Person {
        isAsked = true
        for (p: Person in knows) {
            println("Asking " + p.name)
            p.isAsked = true
            if (p.knows.size == 0) {
                println("Celebrity is found -> " + p.name)
                return p
            }
        }
        return Person("Nobody")
    }
}
package com.algorithms.storehouse.logic.recursion

import java.util.Stack

/*
Print out stack in the same order as it was filled with elements
 */
class StackReversal(
    val stack:Stack<Int>
){
    fun reverse(){
        val e = stack.pop()
        if (!stack.empty()){
            reverse()
        }
        println(e)
    }
}


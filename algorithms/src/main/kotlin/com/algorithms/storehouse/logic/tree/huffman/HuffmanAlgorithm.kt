package com.algorithms.storehouse.logic.tree.huffman

import com.algorithms.storehouse.entities.tree.huffman.CodeTreeNode
import java.util.*
import java.util.function.Consumer

/*
Algorithm description:
https://www.youtube.com/watch?v=OQrwOywESGg
 */
class HuffmanAlgorithm(
    val input: String
) {
    var codesTree: CodeTreeNode? = null
    var codes: TreeMap<Char, String?> = TreeMap()

    init {
        val freqMap = buildFreqMap()
        codesTree = buildCodesTree(freqMap)
        freqMap.keys
            .forEach(Consumer { c: Char -> codes[c] = codesTree!!.getCodeForCharacter(c, "") })
    }

    fun buildFreqMap(): TreeMap<Char, Int> {
        val freqMap = TreeMap<Char, Int>()
        input.codePoints()
            .mapToObj { c: Int -> c.toChar() }
            .forEach { c: Char ->
                val count = freqMap[c]
                freqMap[c] = if (count != null) count + 1 else 1
            }
        return freqMap
    }

    fun buildCodesTree(freqMap: TreeMap<Char, Int>): CodeTreeNode {
        val codeTreeNodes = PriorityQueue<CodeTreeNode>()
        freqMap.keys
            .forEach(Consumer { c: Char -> codeTreeNodes.add(CodeTreeNode(c, freqMap[c]!!)) })
        while (codeTreeNodes.size > 1) {
            val left = codeTreeNodes.poll()
            val right = codeTreeNodes.poll()
            val parent = CodeTreeNode(null, right.weight + left.weight, left, right)
            codeTreeNodes.add(parent)
        }
        return codeTreeNodes.poll()
    }

    fun encode(): String {
        val encoded = StringBuilder()
        input.codePoints()
            .mapToObj { c: Int -> c.toChar() }
            .forEach { c: Char -> encoded.append(codes[c]) }
        return encoded.toString()
    }

    fun decode(encoded: String): String {
        val decoded = StringBuilder()
        var node: CodeTreeNode? = codesTree
        for (i in 0 until encoded.length) {
            node = if (encoded[i] == '0') node!!.left else node!!.right
            if (node!!.content != null) {
                decoded.append(node.content)
                node = codesTree
            }
        }
        return decoded.toString()
    }
}
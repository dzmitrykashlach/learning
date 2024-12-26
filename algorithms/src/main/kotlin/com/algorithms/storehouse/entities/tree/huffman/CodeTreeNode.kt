package com.algorithms.storehouse.entities.tree.huffman

class CodeTreeNode : Comparable<CodeTreeNode> {
    var content: Char?
    var weight: Int
    var left: CodeTreeNode? = null
    var right: CodeTreeNode? = null

    constructor(content: Char?, weight: Int) {
        this.content = content
        this.weight = weight
    }

    constructor(content: Char?, weight: Int, left: CodeTreeNode?, right: CodeTreeNode?) {
        this.content = content
        this.weight = weight
        this.left = left
        this.right = right
    }

    override fun compareTo(other: CodeTreeNode): Int {
        return weight - other.weight
    }

    fun getCodeForCharacter(ch: Char?, parentPath: String): String? {
        if (content === ch) {
            return parentPath
        } else {
            if (left != null) {
                val path = left!!.getCodeForCharacter(ch, parentPath + 0)
                if (path != null) {
                    return path
                }
            }
            if (right != null) {
                val path = right!!.getCodeForCharacter(ch, parentPath + 1)
                if (path != null) {
                    return path
                }
            }
        }
        return null
    }
}
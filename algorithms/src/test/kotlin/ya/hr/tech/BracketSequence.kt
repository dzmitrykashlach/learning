package ya.hr.tech

import java.util.Stack
import kotlin.test.Test
import kotlin.test.assertTrue

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/correct-bracket-sequence
# Проверка правильной скобочной последовательности ((), [], {})
 */

class BracketSequence {
    val opening = setOf('(', '[', '{')

    fun checkSequence(brackets: String): Boolean {
        val stack = Stack<Char>()
        var top = ' '
        brackets.forEach {
            if (it in opening) {
                stack.push(it)
            } else {
                if (stack.empty()) {
                    return false
                }
                top = stack.pop()
                if ((it == ')' && top != '(') ||
                    (it == '}' && top != '{') ||
                    (it == ']' && top != '[')
                ) {
                    return false
                }
            }

        }
        if (stack.empty()) {
            return true
        } else {
            return true
        }

    }


}

class BracketSequenceTest {
    @Test
    fun checkSequenceTest() {
        val brackets = "(()[]{})"
        assertTrue { BracketSequence().checkSequence(brackets) }
    }
}
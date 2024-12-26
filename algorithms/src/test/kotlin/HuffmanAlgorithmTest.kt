import com.algorithms.storehouse.logic.tree.huffman.HuffmanAlgorithm
import kotlin.test.assertEquals
import kotlin.test.Test

class HuffmanAlgorithmTest {
    @Test
    fun encodeTest() {
        val input = "I can still remember a time when I knew more than my phone"
        val algorithm = HuffmanAlgorithm(input)
        assert(input.toByteArray().size * 8 == 464)
        assertEquals(
            "{ =01, I=11011, a=0000, b=100100," +
                    " c=100101, e=101, h=0011, i=10011, k=110000, " +
                    "l=10000, m=1111, n=1110, o=10001, " +
                    "p=110011, r=0010, s=110001, t=0001, w=11010, y=110010}", algorithm.codes.toString()
        )
        val encoded = algorithm.encode()
        assertEquals(222, encoded.length.toLong())
        assertEquals(
            "11011011001010000111001110001000110011100001" +
                    "00000100101011111101111110010010100100100000100011001111111" +
                    "0101110100011101111001110110111000011101011101001111110001001010" +
                    "1010001001100001110011111110010011100110011100011110101", encoded
        )
        val decoded = algorithm.decode(encoded)
        assertEquals("I can still remember a time when I knew more than my phone", decoded)
    }
}
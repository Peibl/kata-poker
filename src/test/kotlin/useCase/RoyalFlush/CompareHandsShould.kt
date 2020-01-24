package useCase.RoyalFlush


import domain.Card
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import useCase.CompareHands

class CompareHandsShould {

    @Test
    fun `return that the royal flush wins to straight flush`() {
        val result = compareHands().execute(SOME_ROYAL_FLUSH_HAND, SOME_STRAIGHT_FLUSH_HAND)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `return that the royal flush wins to straight flush 2`() {
        val result = compareHands().execute(SOME_STRAIGHT_FLUSH_HAND, SOME_ROYAL_FLUSH_HAND)

        assertThat(result).isEqualTo(-1)
    }


    @Test
    fun `return tie on two royal flush`() {
        val result = compareHands().execute(SOME_ROYAL_FLUSH_HAND, OTHER_ROYAL_FLUSH_HAND)

        assertThat(result).isEqualTo(0)
    }

//    @Test
//    fun `return that the second wins by poker`() {
//        val firstHand = mutableListOf("2C", "3H", "4S", "9h", "QH").map { Card(it[0], it[1]) }
//        val secondHand = mutableListOf("2H", "2D", "2S", "2C", "QD").map { Card(it[0], it[1]) }
//
//        val result = compareHands().execute(firstHand, secondHand)
//
//        assertThat(result).isEqualTo(-1)
//    }
//
//    @Test
//    fun `return that the first wins by high poker`() {
//        val firstHand = mutableListOf("4H", "4D", "4S", "4C", "QD").map { Card(it[0], it[1]) }
//        val secondHand = mutableListOf("2C", "2H", "2S", "2h", "QH").map { Card(it[0], it[1]) }
//
//        val result = compareHands().execute(firstHand, secondHand)
//
//        assertThat(result).isEqualTo(1)
//    }
//
//    @Test
//    fun `return that the second wins by high poker`() {
//        val firstHand = mutableListOf("2C", "2H", "2S", "2h", "QH").map { Card(it[0], it[1]) }
//        val secondHand = mutableListOf("4H", "4D", "4S", "4C", "QD").map { Card(it[0], it[1]) }
//
//        val result = compareHands().execute(firstHand, secondHand)
//
//        assertThat(result).isEqualTo(-1)
//    }

    private fun compareHands(): CompareHands {
        return CompareHands()
    }

    private val SOME_ROYAL_FLUSH_HAND = mutableListOf("AH", "KH", "QH", "JH", "TH").map { Card(it[0], it[1]) }
    private val OTHER_ROYAL_FLUSH_HAND = mutableListOf("AH", "KH", "QH", "JH", "TH").map { Card(it[0], it[1]) }
    private val SOME_STRAIGHT_FLUSH_HAND = mutableListOf("7C", "8C", "9C", "TC", "JC").map { Card(it[0], it[1]) }
}




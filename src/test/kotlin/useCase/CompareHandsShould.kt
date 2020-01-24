package useCase


import domain.Card
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CompareHandsShould {

    @Test
    fun `return that the first wins by poker`() {
        val firstHand = mutableListOf("2H", "2D", "2S", "2C", "QD").map { Card(it[0], it[1]) }
        val secondHand = mutableListOf("2C", "3H", "4S", "9h", "QH").map { Card(it[0], it[1]) }

        val result = compareHands().execute(firstHand, secondHand)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `return that the second wins by poker`() {
        val firstHand = mutableListOf("2C", "3H", "4S", "9h", "QH").map { Card(it[0], it[1]) }
        val secondHand = mutableListOf("2H", "2D", "2S", "2C", "QD").map { Card(it[0], it[1]) }

        val result = compareHands().execute(firstHand, secondHand)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `return that the first wins by high poker`() {
        val firstHand = mutableListOf("4H", "4D", "4S", "4C", "QD").map { Card(it[0], it[1]) }
        val secondHand = mutableListOf("2C", "2H", "2S", "2h", "QH").map { Card(it[0], it[1]) }

        val result = compareHands().execute(firstHand, secondHand)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `return that the second wins by high poker`() {
        val firstHand = mutableListOf("2C", "2H", "2S", "2h", "QH").map { Card(it[0], it[1]) }
        val secondHand = mutableListOf("4H", "4D", "4S", "4C", "QD").map { Card(it[0], it[1]) }

        val result = compareHands().execute(firstHand, secondHand)

        assertThat(result).isEqualTo(-1)
    }

    private fun compareHands(): CompareHands {
        return CompareHands()
    }
}




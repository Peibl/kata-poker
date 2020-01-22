package useCase


import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CompareHigherRankShould {
    @Test
    fun `return that the second hand wins by highest card`() {
        val firstHand = mutableListOf("2H", "3D", "5S", "9C", "KD")
        val secondHand = mutableListOf("2C", "3H", "4S", "8C", "AH")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("Second wins. - with high card: AH")
    }

    @Test
    fun `return that the first wins by highest card`() {
        val firstHand = mutableListOf("2H", "3D", "5S", "9C", "QD")
        val secondHand = mutableListOf("2C", "3H", "4S", "8C", "5H")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("First wins. - with high card: QD")
    }

    @Test
    fun `return that the first wins when tie in first high card `() {
        val firstHand = mutableListOf("2H", "3D", "5S", "9C", "QD")
        val secondHand = mutableListOf("2C", "3H", "4S", "8C", "QH")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("First wins. - with high card: 9C")
    }

    @Test
    fun `return that the first wins when tie in first and second high card `() {
        val firstHand = mutableListOf("2H", "3D", "5S", "9C", "QD")
        val secondHand = mutableListOf("2C", "3H", "4S", "9h", "QH")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("First wins. - with high card: 5S")
    }

    @Test
    fun `return that the first wins by poker`() {
        val firstHand = mutableListOf("2H", "2D", "2S", "2C", "QD")
        val secondHand = mutableListOf("2C", "3H", "4S", "9h", "QH")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("First wins. - with poker")
    }
    @Test
    fun `return that the second wins by poker`() {
        val firstHand = mutableListOf("2C", "3H", "4S", "9h", "QH")
        val secondHand = mutableListOf("2H", "2D", "2S", "2C", "QD")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("Second wins. - with poker")
    }

    @Test
    fun `return that the second wins by high poker`() {
        val firstHand = mutableListOf("2C", "2H", "2S", "2h", "QH")
        val secondHand = mutableListOf("4H", "4D", "4S", "4C", "QD")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("Second wins. - with poker")
    }

    @Test
    fun `return that the first wins by high poker`() {
        val firstHand = mutableListOf("4H", "4D", "4S", "4C", "QD")
        val secondHand = mutableListOf("2C", "2H", "2S", "2h", "QH")

        val result = compareHigherRank().execute(firstHand, secondHand)

        assertThat(result).isEqualTo("First wins. - with poker")
    }


    private fun compareHigherRank(): CompareHigherRank {

        return CompareHigherRank()
    }
}




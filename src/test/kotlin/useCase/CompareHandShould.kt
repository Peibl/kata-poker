package useCase


import domain.Card
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import useCase.HandFixture.aFlushHand
import useCase.HandFixture.aFullHouseHand
import useCase.HandFixture.aHighCardHand
import useCase.HandFixture.aOnePairHand
import useCase.HandFixture.aPocketHand
import useCase.HandFixture.aQuadHand
import useCase.HandFixture.aRoyalFlushHand
import useCase.HandFixture.aSetHand
import useCase.HandFixture.aStraightFlushHand
import useCase.HandFixture.aStraightHand
import useCase.HandFixture.otherRoyalFlushHand


@RunWith(Parameterized::class)
class CompareHandShould(private val hand: List<Card>, private val otherHand: List<Card>, private val result: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf(aRoyalFlushHand(), otherRoyalFlushHand(), 0),
                arrayOf(otherRoyalFlushHand(), aRoyalFlushHand(), 0),
                arrayOf(aRoyalFlushHand(), aStraightFlushHand(), 1),
                arrayOf(aRoyalFlushHand(), aQuadHand(), 1),
                arrayOf(aRoyalFlushHand(), aFullHouseHand(), 1),
                arrayOf(aRoyalFlushHand(), aFlushHand(), 1),
                arrayOf(aRoyalFlushHand(), aStraightHand(), 1),
                arrayOf(aRoyalFlushHand(), aSetHand(), 1),
                arrayOf(aRoyalFlushHand(), aPocketHand(), 1),
                arrayOf(aRoyalFlushHand(), aOnePairHand(), 1),
                arrayOf(aRoyalFlushHand(), aHighCardHand(), 1),

                arrayOf(aStraightFlushHand(), aRoyalFlushHand(), -1)
            )
        }
    }

    @Test
    fun `compare hands rank`() {
        val response = compareHands().execute(hand , otherHand )

        assertThat(response).isEqualTo(result)
    }
    private fun compareHands(): CompareHands {
        return CompareHands()
    }

}




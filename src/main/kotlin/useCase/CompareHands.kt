package useCase

import domain.Card
import domain.Hand

class CompareHands {
    fun execute(hand: List<Card>, otherHand: List<Card>): Int {
        return calculateResult(Hand(hand), Hand(otherHand))
    }

    private fun calculateResult(hand: Hand, other: Hand): Int {
        return hand.compareTo(other)
    }
}

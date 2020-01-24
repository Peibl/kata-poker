package useCase

import domain.Card
import domain.Hand

class CompareHands {
    fun execute(firstHand: List<Card>, secondHand: List<Card>): Int {
        return calculateResult(Hand(firstHand), Hand(secondHand))
    }

    private fun calculateResult(hand: Hand, other: Hand): Int {
        return hand.compareTo(other)
    }
}

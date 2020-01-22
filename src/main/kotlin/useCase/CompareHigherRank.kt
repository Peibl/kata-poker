package useCase

import domain.Card
import domain.Hand
import domain.PokerType

class CompareHigherRank() {
    fun execute(firstHand: List<String>, secondHand: List<String>): String {
        return calculateResult(Hand(firstHand), Hand(secondHand))
    }

    private fun calculateResult(firstHand: Hand, secondHand: Hand): String {
//        if (firstHand.type === PokerType.HIGH_CARD && secondHand.type === PokerType.HIGH_CARD) {
//            val highCardForFistHand = firstHand.getHighCard()
//            val highCardForSecondHand = secondHand.getHighCard()
//            if (highCardForFistHand.weighing == highCardForSecondHand.weighing) {
//                return resolveOnFirstHighTie(firstHand, secondHand)
//            }
//            return compareCard(highCardForFistHand, highCardForSecondHand)
//        }
        return if (firstHand.rank > secondHand.rank) {
            "First wins. - with " + firstHand.rank
        } else {
            "Second wins. - with " + firstHand.rank
        }

    }

    private fun resolveOnFirstHighTie(firstHand: Hand, secondHand: Hand): String {
        val secondHighCardForFirstHand = firstHand.getSecondHighCard()
        val secondHighCardForSecondCard = secondHand.getSecondHighCard()
        if (secondHighCardForFirstHand.weighing == secondHighCardForSecondCard.weighing) {
            return resolveOnSecondHighTie(firstHand, secondHand)
        }
        return compareCard(secondHighCardForFirstHand, secondHighCardForSecondCard)
    }

    private fun resolveOnSecondHighTie(firstHand: Hand, secondHand: Hand): String {
        val thirdHighCardForFirstHand = firstHand.getThirdHighCard()
        val thirdHighCardForSecondCard = secondHand.getThirdHighCard()
        return compareCard(thirdHighCardForFirstHand, thirdHighCardForSecondCard)
    }

    private fun compareCard(highCardForFistHand: Card, highCardForSecondHand: Card): String {
        return if (highCardForFistHand.weighing > highCardForSecondHand.weighing) {
            "First wins. - with high card: $highCardForFistHand"
        } else {
            "Second wins. - with high card: $highCardForSecondHand"
        }
    }

}

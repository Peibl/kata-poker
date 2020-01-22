package domain

enum class PokerType {
    POKER, HIGH_CARD, NONE
}
class Hand( hand: List<String>) {
    var cards: List<Card> = hand.map { Card(it[0], it[1]) }
    var rank: Rank = HighCard(this)

    init {
        if (this.hasPoker()) {
            rank = Poker(this)
        }else{
            rank = HighCard(this)
        }
    }

    fun getHighCard(): Card {
        return cards.maxBy { it.weighing }!!
    }

    fun getSecondHighCard(): Card {
        val highCard = this.getHighCard()
        val aux = cards.toMutableList()
        aux.remove(highCard)
        return aux.maxBy { it.weighing }!!
    }

    fun getThirdHighCard(): Card {
        val highCard = this.getHighCard()
        val secondHighCard = this.getSecondHighCard()
        val aux = cards.toMutableList()
        aux.remove(highCard)
        aux.remove(secondHighCard)
        return aux.maxBy { it.weighing }!!
    }

    fun hasPoker(): Boolean {
        val map = cards.groupingBy { it.value }.eachCount()
        return map.values.contains(4)
    }
}


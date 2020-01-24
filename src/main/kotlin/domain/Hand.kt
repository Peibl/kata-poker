package domain

class Hand( val cards: List<Card> ) {
    private var rank: Rank = HighCard(cards)

    init {
        if (this.hasPoker()) {
            rank = Quad(cards)
        }else{
            rank = HighCard(cards)
        }
    }

    fun hasPoker(): Boolean {
        val map = cards.groupingBy { it.value }.eachCount()
        return map.values.contains(4)
    }

    operator fun compareTo(other: Hand): Int {
        return this.rank.compareTo(other.rank)
    }
}


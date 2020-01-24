package domain

class Hand(cards: List<Card> ) {
    private var rank: Rank = HighCard(cards)

    init {
        when {
            RoyalFlush.check(cards) -> rank = RoyalFlush(cards)
            StraightFlush.check(cards) -> rank = StraightFlush(cards)
            Quad.check(cards) -> rank = Quad(cards)
            Full.check(cards) -> rank = Full(cards)
            Flush.check(cards) -> rank = Flush(cards)
            else -> rank = HighCard(cards)
        }
    }

    operator fun compareTo(other: Hand): Int {
        return this.rank.compareTo(other.rank)
    }
}


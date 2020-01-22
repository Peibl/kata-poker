package domain

class HighCard(hand: Hand) : Rank(hand) {
    override fun value() = 200
    override fun toString(): String {
        return "high card: "+ hand.getHighCard()
    }

}

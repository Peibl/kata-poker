package domain

class Poker(hand: Hand) : Rank(hand) {
    override fun value() = 900 + hand.cards.sumBy { it.weighing }
    override fun toString(): String {
        return "poker"
    }

}

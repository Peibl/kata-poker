package domain

abstract class Rank(val hand: Hand) {
    abstract fun value(): Int
    operator fun compareTo(rank: Rank): Int {
        if (rank.value() > this.value()) return -1
        if (rank.value() < this.value()) return 1
        return 0
    }
}

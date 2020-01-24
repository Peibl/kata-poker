package domain

abstract class Rank {
    abstract val score: Int
    abstract val tieScore: Int
    operator fun compareTo(rank: Rank): Int {
        if (rank.score < this.score) return -1
        if (rank.score > this.score) return 1
        if (rank.tieScore > this.tieScore) return -1
        if (rank.tieScore < this.tieScore) return 1
        return 0
    }
}

class Quad(val cards: List<Card>) : Rank() {
    override val tieScore: Int
        get() = cards.sortedBy { it.value }[2].weighing
    override val score: Int
        get() = 3
}

class HighCard(val cards: List<Card>) : Rank() {
    override val tieScore: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val score: Int
        get() = 10
}

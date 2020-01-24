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

class RoyalFlush(private val cards: List<Card>) : Rank() {
    override val score: Int
        get() = 1
    override val tieScore: Int
        get() = 0

    companion object {
        private val royalFlushH = mutableListOf("AH", "KH", "QH", "JH", "TH").map { Card(it[0], it[1]) }
        private val royalFlushC = mutableListOf("AC", "KC", "QC", "JC", "TC").map { Card(it[0], it[1]) }
        private val royalFlushD = mutableListOf("AD", "KD", "QD", "JD", "TD").map { Card(it[0], it[1]) }
        private val royalFlushS = mutableListOf("AS", "KS", "QS", "JS", "TS").map { Card(it[0], it[1]) }
        private val royalFlushes = mutableListOf(royalFlushC, royalFlushH, royalFlushD, royalFlushS)
        fun check(cards: List<Card>): Boolean {
            return royalFlushes.contains(cards.sortedByDescending { it.weighing })
        }
    }
}

class StraightFlush(private val cards: List<Card>) : Rank() {
    override val score: Int
        get() = 2
    override val tieScore: Int
        get() = cards.sortedBy { it.value }[2].weighing

    companion object {
        fun check(cards: List<Card>): Boolean {
            return verifyStraight(cards) && verifyFlush(cards)
        }

        private fun verifyFlush(cards: List<Card>): Boolean {
            val map = cards.groupingBy { it.suit }.eachCount()
            return map.values.contains(5)
        }

        private fun verifyStraight(cards: List<Card>): Boolean {
            val cardValues = cards.sortedBy { it.weighing }.map { it.weighing }
            val expectedValues = mutableListOf(0, 1, 2, 3, 4).map { cardValues[0] + it }
            return expectedValues.containsAll(cardValues)
        }
    }
}

class Quad(private val cards: List<Card>) : Rank() {
    override val score: Int
        get() = 3
    override val tieScore: Int
        get() = cards.sortedBy { it.weighing }[2].weighing

    companion object {
        fun check(cards: List<Card>): Boolean {
            val map = cards.groupingBy { it.value }.eachCount()
            return map.values.contains(4)
        }
    }
}

class HighCard(val cards: List<Card>) : Rank() {
    override val score: Int
        get() = 10
    override val tieScore: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

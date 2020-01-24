package useCase

import domain.Card


object HandFixture {
    fun aRoyalFlushHand() = mutableListOf("AH", "KH", "QH", "JH", "TH").map { Card(it[0], it[1]) }
    fun otherRoyalFlushHand() = mutableListOf("AH", "KH", "QH", "JH", "TH").map { Card(it[0], it[1]) }

    fun aStraightFlushHand() = mutableListOf("7C", "8C", "9C", "TC", "JC").map { Card(it[0], it[1]) }
    fun otherStraightFlushHand() = mutableListOf("7H", "8H", "9H", "TH", "JH").map { Card(it[0], it[1]) }
    fun anotherStraightFlushHand() = mutableListOf("2H", "3H", "4H", "5H", "6H").map { Card(it[0], it[1]) }

    fun aQuadHand() = mutableListOf("7C", "7h", "7D", "7S", "JC").map { Card(it[0], it[1]) }

    fun aFullHouseHand() = mutableListOf("6C", "6H", "6D", "3S", "3C").map { Card(it[0], it[1]) }

    fun aFlushHand() = mutableListOf("2H", "7H", "JH", "AH", "4H").map { Card(it[0], it[1]) }

    fun aStraightHand() = mutableListOf("7C", "8H", "9S", "TC", "JC").map { Card(it[0], it[1]) }

    fun aSetHand() = mutableListOf("8C", "8H", "8S", "2C", "TH").map { Card(it[0], it[1]) }

    fun aPocketHand() = mutableListOf("QC", "QH", "5S", "2C", "5H").map { Card(it[0], it[1]) }

    fun aOnePairHand() = mutableListOf("KC", "KH", "7S", "2C", "JH").map { Card(it[0], it[1]) }

    fun aHighCardHand() = mutableListOf("QC", "7H", "5S", "3C", "TH").map { Card(it[0], it[1]) }

}

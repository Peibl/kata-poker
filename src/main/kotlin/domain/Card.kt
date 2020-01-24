package domain

class Card(val value: Char, val suit: Char) {
    var weighing: Int = 0
        get() {
            val cardValue = value
            if (cardValue == 'A') return 14
            if (cardValue == 'K') return 13
            if (cardValue == 'Q') return 12
            if (cardValue == 'J') return 11
            if (cardValue == 'T') return 10
            return cardValue.toString().toInt(10)
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (value != other.value) return false
        if (suit != other.suit) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + suit.hashCode()
        return result
    }

    override fun toString(): String {
        return "$value$suit"
    }


}

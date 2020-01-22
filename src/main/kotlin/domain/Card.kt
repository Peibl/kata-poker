package domain

class Card(val value: Char, val symbol: Char) {
    var weighing: Int = 0
        get() {
            val cardValue = value
            if (cardValue == 'A') return 80
            if (cardValue == 'K') return 60
            if (cardValue == 'Q') return 40
            if (cardValue == 'J') return 20
            if (cardValue == 'T') return 15
            return cardValue.toString().toInt(10)
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (value != other.value) return false
        if (symbol != other.symbol) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + symbol.hashCode()
        return result
    }

    override fun toString(): String {
        return "$value$symbol"
    }


}

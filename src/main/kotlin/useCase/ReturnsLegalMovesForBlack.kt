package useCase

class ReturnsLegalMovesForBlack {
    fun execute(board: List<String>): List<String> {
        val result = mutableListOf<String>()

        if (board.contains("87W")) {
            val minBy = board.minBy { it[1] }!!
            val pos = (minBy[1].toString().toInt() - 1)
            result += "8$pos"
        }

        if (board.contains("78W")) {
            val minBy = board.minBy { it[0] }!!
            val pos = (minBy[0].toString().toInt() - 1)
            result += "${pos}8"
        }

        if (board.contains("21W")) {
            val maxBy = board.maxBy { it[0] }!!
            val pos = (maxBy[0].toString().toInt() + 1)
            result += "${pos}1"
        }

        if (board.contains("12W")) {
            val maxBy = board.maxBy { it[1] }!!
            val pos = (maxBy[1].toString().toInt() + 1)
            result += "1$pos"
        }
        return result
    }
}

package useCase


import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class ReturnsLegalMovesShouldBlack {

    @Test
    fun `return one legal move jumping one to right`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "12W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("13"))
    }

    @Test
    fun `return one legal move jumping two to right`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "12W", "13W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("14"))
    }

    @Test
    fun `return one legal move jumping four to right`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "12W", "13W", "14W", "15W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("16"))
    }

    @Test
    fun `return one legal move jumping one to down`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "21W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("31"))
    }

    @Test
    fun `return one legal move jumping two to down`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "21W", "31W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("41"))
    }

    @Test
    fun `return one legal move jumping three to down`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "21W", "31W", "41W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("51"))
    }

    @Test
    fun `return 2 legal moves jumping one to right and one to down`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "12W", "21W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("13", "31"))
    }

    @Test
    fun `return 2 legal moves jumping two to right and two to down`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("11B", "12W", "13W", "21W", "31W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("14", "41"))
    }

    @Test
    fun `return one legal move jumping one to left`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("88B", "87W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("86"))
    }

    @Test
    fun `return one legal move jumping two to left`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("88B", "87W", "86W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("85"))
    }

    @Test
    fun `return one legal move jumping one to top`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("88B", "78W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("68"))
    }

    @Test
    fun `return one legal move jumping two to top`() {
        val results = ReturnsLegalMovesForBlack().execute(mutableListOf("88B", "78W", "68W"));
        assertThat(results).containsExactlyInAnyOrderElementsOf(mutableListOf("58"))
    }

}




package de.sluit.dnd.dice

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.willReturn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DiceTest {

    val die1: Die = mock()
    val die2: Die = mock()
    val die3: Die = mock()

    @Test fun `role with one die is calculated correctly`() {
        given { die1.roll() } willReturn { 1 }
        val role = Dice(die1).roll()
        assertThat(role).isEqualTo(1)
    }

    @Test fun `role with two dice is calculated correctly`() {
        given { die1.roll() } willReturn { 1 }
        given { die2.roll() } willReturn { 2 }
        val role = Dice(die1, die2).roll()
        assertThat(role).isEqualTo(3)
    }

    @Test fun `role with three dice is calculated correctly`() {
        given { die1.roll() } willReturn { 1 }
        given { die2.roll() } willReturn { 2 }
        given { die3.roll() } willReturn { 3 }
        val role = Dice(die1, die2, die3).roll()
        assertThat(role).isEqualTo(6)
    }


}
package de.sluit.dnd.dice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

interface DieContract {

    fun getTestInstance(): Die
    val numberOfSides: Int

    @Test fun `all rolls are between 1 and the number of sides of the die`() {
        val die = getTestInstance()
        (1..1000)
                .map { die.roll() }
                .forEach {
                    Assertions.assertThat(it).isGreaterThanOrEqualTo(1)
                    Assertions.assertThat(it).isLessThanOrEqualTo(numberOfSides)
                }

    }

    @Test fun `within 1000 rolls each side was rolled at least once`() {
        val die = getTestInstance()
        val distinctRolls = (1..1000).map { die.roll() }.toSet()
        Assertions.assertThat(distinctRolls).containsAll(1..numberOfSides)
    }

}
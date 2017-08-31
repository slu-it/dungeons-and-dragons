package de.sluit.dnd.dice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DieTest {

    @Nested inner class `D20 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D20()
        override val numberOfSides: Int = 20
    }

    @Nested inner class `D12 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D12()
        override val numberOfSides: Int = 12
    }

    @Nested inner class `D10 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D10()
        override val numberOfSides: Int = 10
    }

    @Nested inner class `D8 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D8()
        override val numberOfSides: Int = 8
    }

    @Nested inner class `D6 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D6()
        override val numberOfSides: Int = 6
    }

    @Nested inner class `D4 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D4()
        override val numberOfSides: Int = 4
    }

    @Nested inner class `D3 die` : DieContract() {
        override fun getTestInstance(): Die = Die.D3()
        override val numberOfSides: Int = 3
    }

    abstract class DieContract {

        abstract fun getTestInstance(): Die
        abstract val numberOfSides: Int

        @Test fun `all rolls are between 1 and the number of sides of the die`() {
            val die = getTestInstance()
            (1..1000)
                    .map { die.roll() }
                    .forEach {
                        assertThat(it).isGreaterThanOrEqualTo(1)
                        assertThat(it).isLessThanOrEqualTo(numberOfSides)
                    }

        }

        @Test fun `within 1000 rolls each side was rolled at least once`() {
            val die = getTestInstance()
            val distinctRolls = (1..1000).map { die.roll() }.toSet()
            assertThat(distinctRolls).containsAll(1..numberOfSides)
        }

    }

}
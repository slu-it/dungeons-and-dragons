package de.sluit.dnd.rolls

data class SavingThrowRoll(
        private val value: Int
) : Comparable<SavingThrowRoll> {

    override fun compareTo(other: SavingThrowRoll) = value.compareTo(other.value)

    fun add(additionalValue: Int): SavingThrowRoll {
        return SavingThrowRoll(value + additionalValue)
    }

}
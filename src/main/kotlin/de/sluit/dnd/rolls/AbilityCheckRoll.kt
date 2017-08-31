package de.sluit.dnd.rolls

data class AbilityCheckRoll(
        private val value: Int
) : Comparable<AbilityCheckRoll> {

    override fun compareTo(other: AbilityCheckRoll) = value.compareTo(other.value)

    fun add(additionalValue: Int): AbilityCheckRoll {
        return AbilityCheckRoll(value + additionalValue)
    }

}
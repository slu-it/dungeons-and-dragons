package de.sluit.dnd.rolls

data class DamageRoll(
        private val value: Int
) : Comparable<DamageRoll> {

    override fun compareTo(other: DamageRoll) = value.compareTo(other.value)

    fun add(additionalValue: Int): DamageRoll {
        return DamageRoll(value + additionalValue)
    }

}
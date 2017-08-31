package de.sluit.dnd.rolls

data class AttackRoll(
        private val value: Int
) : Comparable<AttackRoll> {

    override fun compareTo(other: AttackRoll) = value.compareTo(other.value)

    fun add(additionalValue: Int): AttackRoll {
        return AttackRoll(value + additionalValue)
    }

}
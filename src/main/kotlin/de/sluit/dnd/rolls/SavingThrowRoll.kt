package de.sluit.dnd.rolls

data class SavingThrowRoll(
        val roll: Int = 0,
        val abilityModifier: Int = 0,
        val proficiencyBonus: Int = 0
) : Comparable<SavingThrowRoll> {

    val total: Int
        get() = roll + abilityModifier + proficiencyBonus

    override fun compareTo(other: SavingThrowRoll) = total.compareTo(other.total)

    fun withRoll(value: Int) = copy(roll = value)
    fun withAbilityModifier(value: Int) = copy(abilityModifier = value)
    fun withProficiencyBonus(value: Int) = copy(proficiencyBonus = value)

}
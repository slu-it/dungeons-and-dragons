package de.sluit.dnd.rolls

data class AbilityCheckRoll(
        val roll: Int = 0,
        val abilityModifier: Int = 0,
        val proficiencyBonus: Int = 0
) : Roll {

    override val total: Int
        get() = roll + abilityModifier + proficiencyBonus

    fun withRoll(value: Int) = copy(roll = value)
    fun withAbilityModifier(value: Int) = copy(abilityModifier = value)
    fun withProficiencyBonus(value: Int) = copy(proficiencyBonus = value)

}
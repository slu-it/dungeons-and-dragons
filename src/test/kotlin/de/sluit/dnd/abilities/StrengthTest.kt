package de.sluit.dnd.abilities

class StrengthTest : AbilityContract {
    override fun createAbilityInstance(score: Int) = Strength(score)
}
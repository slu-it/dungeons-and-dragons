package de.sluit.dnd.abilities

class CharismaTest : AbilityContract {
    override fun createAbilityInstance(score: Int) = Charisma(score)
}
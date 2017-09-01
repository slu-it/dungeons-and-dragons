package de.sluit.dnd.abilities

class ConstitutionTest : AbilityContract {
    override fun createAbilityInstance(score: Int) = Constitution(score)
}
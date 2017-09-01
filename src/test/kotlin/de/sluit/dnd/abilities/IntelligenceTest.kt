package de.sluit.dnd.abilities

class IntelligenceTest : AbilityContract {
    override fun createAbilityInstance(score: Int) = Intelligence(score)
}
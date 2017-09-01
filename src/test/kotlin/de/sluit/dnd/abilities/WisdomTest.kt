package de.sluit.dnd.abilities

class WisdomTest : AbilityContract {
    override fun createAbilityInstance(score: Int) = Wisdom(score)
}
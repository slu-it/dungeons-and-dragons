package de.sluit.dnd.abilities

class DexterityTest : AbilityContract {
    override fun createAbilityInstance(score: Int) = Dexterity(score)
}
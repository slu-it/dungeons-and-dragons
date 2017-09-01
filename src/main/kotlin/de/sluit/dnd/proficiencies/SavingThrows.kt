package de.sluit.dnd.proficiencies

import de.sluit.dnd.abilities.*


object StrengthSavingThrow : SavingThrow(Strength)
object DexteritySavingThrow : SavingThrow(Dexterity)
object ConstitutionSavingThrow : SavingThrow(Constitution)
object IntelligenceSavingThrow : SavingThrow(Intelligence)
object WisdomSavingThrow : SavingThrow(Wisdom)
object CharismaSavingThrow : SavingThrow(Charisma)

sealed class SavingThrow(
        val associatedAbility: Ability
)
package de.sluit.dnd

import de.sluit.dnd.proficiencies.*

object Barbarian : CharacterClass(
        savingThrowProficiencies = setOf(StrengthSavingThrow, ConstitutionSavingThrow)
)

object Bard : CharacterClass(
        savingThrowProficiencies = setOf(DexteritySavingThrow, CharismaSavingThrow)
)

object Cleric : CharacterClass(
        savingThrowProficiencies = setOf(WisdomSavingThrow, CharismaSavingThrow)
)

object Druid : CharacterClass(
        savingThrowProficiencies = setOf(IntelligenceSavingThrow, WisdomSavingThrow)
)

object Fighter : CharacterClass(
        savingThrowProficiencies = setOf(StrengthSavingThrow, ConstitutionSavingThrow)
)

object Monk : CharacterClass(
        savingThrowProficiencies = setOf(StrengthSavingThrow, DexteritySavingThrow)
)

object Paladin : CharacterClass(
        savingThrowProficiencies = setOf(WisdomSavingThrow, CharismaSavingThrow)
)

object Ranger : CharacterClass(
        savingThrowProficiencies = setOf(StrengthSavingThrow, DexteritySavingThrow)
)

object Rogue : CharacterClass(
        savingThrowProficiencies = setOf(DexteritySavingThrow, IntelligenceSavingThrow)
)

object Sorcerer : CharacterClass(
        savingThrowProficiencies = setOf(ConstitutionSavingThrow, CharismaSavingThrow)
)

object Warlock : CharacterClass(
        savingThrowProficiencies = setOf(WisdomSavingThrow, CharismaSavingThrow)
)

object Wizard : CharacterClass(
        savingThrowProficiencies = setOf(IntelligenceSavingThrow, WisdomSavingThrow)
)

sealed class CharacterClass(
        val savingThrowProficiencies: Set<SavingThrow>
)
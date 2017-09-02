package de.sluit.dnd

import de.sluit.dnd.abilities.*

object Barbarian : CharacterClass(
        savingThrowProficiencies = setOf(Strength, Constitution)
)

object Bard : CharacterClass(
        savingThrowProficiencies = setOf(Dexterity, Charisma)
)

object Cleric : CharacterClass(
        savingThrowProficiencies = setOf(Wisdom, Charisma)
)

object Druid : CharacterClass(
        savingThrowProficiencies = setOf(Intelligence, Wisdom)
)

object Fighter : CharacterClass(
        savingThrowProficiencies = setOf(Strength, Constitution)
)

object Monk : CharacterClass(
        savingThrowProficiencies = setOf(Strength, Dexterity)
)

object Paladin : CharacterClass(
        savingThrowProficiencies = setOf(Wisdom, Charisma)
)

object Ranger : CharacterClass(
        savingThrowProficiencies = setOf(Strength, Dexterity)
)

object Rogue : CharacterClass(
        savingThrowProficiencies = setOf(Dexterity, Intelligence)
)

object Sorcerer : CharacterClass(
        savingThrowProficiencies = setOf(Constitution, Charisma)
)

object Warlock : CharacterClass(
        savingThrowProficiencies = setOf(Wisdom, Charisma)
)

object Wizard : CharacterClass(
        savingThrowProficiencies = setOf(Intelligence, Wisdom)
)

sealed class CharacterClass(
        val savingThrowProficiencies: Set<Ability>
)
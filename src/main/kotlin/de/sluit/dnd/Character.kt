package de.sluit.dnd

import de.sluit.dnd.abilities.*
import de.sluit.dnd.dice.D20
import de.sluit.dnd.proficiencies.*
import de.sluit.dnd.rolls.AbilityCheckRoll
import de.sluit.dnd.rolls.AttackRoll
import de.sluit.dnd.rolls.Roll
import de.sluit.dnd.rolls.SavingThrowRoll

class Character {

    // TODO
    // https://roll20.net/compendium/dnd5e/Rules:Ability%20Scores#h-Ability%20Scores
    //  - Passive Checks
    //  - Saving Throws

    private val d20 = D20()
    private var level = Level(1)
    private val characterClass: CharacterClass = Barbarian

    // ### abilities

    var strength = Strength(1)
    var dexterity = Dexterity(1)
    var constitution = Constitution(1)
    var intelligence = Intelligence(1)
    var wisdom = Wisdom(1)
    var charisma = Charisma(1)

    // ### proficiencies

    val skills = mutableListOf<Skill>()

    val savingThrowProficiencies: List<SavingThrow>
        get() = characterClass.savingThrowProficiencies.toList() // might be more?

    // ### ability checks

    val strengthCheck = { abilityCheck(strength) }
    val dexterityCheck = { abilityCheck(dexterity) }
    val constitutionCheck = { abilityCheck(constitution) }
    val intelligenceCheck = { abilityCheck(intelligence) }
    val wisdomCheck = { abilityCheck(wisdom) }
    val charismaCheck = { abilityCheck(charisma) }

    private fun abilityCheck(ability: Ability): AbilityCheckRoll {
        return AbilityCheckRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(ability.modifier)
    }

    // ### skill checks

    val athleticsCheck = { skillCheck(Athletics, strength) }
    val acrobaticsCheck = { skillCheck(Acrobatics, dexterity) }
    val sleightOfHandCheck = { skillCheck(SleightOfHand, dexterity) }
    val stealthCheck = { skillCheck(Stealth, dexterity) }
    val arcanaCheck = { skillCheck(Arcana, intelligence) }
    val historyCheck = { skillCheck(History, intelligence) }
    val investigationCheck = { skillCheck(Investigation, intelligence) }
    val natureCheck = { skillCheck(Nature, intelligence) }
    val religionCheck = { skillCheck(Religion, intelligence) }
    val animalHandlingCheck = { skillCheck(AnimalHandling, wisdom) }
    val insightCheck = { skillCheck(Insight, wisdom) }
    val medicineCheck = { skillCheck(Medicine, wisdom) }
    val perceptionCheck = { skillCheck(Perception, wisdom) }
    val survivalCheck = { skillCheck(Survival, wisdom) }
    val deceptionCheck = { skillCheck(Deception, charisma) }
    val intimidationCheck = { skillCheck(Intimidation, charisma) }
    val performanceCheck = { skillCheck(Performance, charisma) }
    val persuasionCheck = { skillCheck(Persuasion, charisma) }

    private fun skillCheck(skill: Skill, ability: Ability): AbilityCheckRoll {
        val roll = abilityCheck(ability)
        if (skills.contains(skill)) {
            return roll.withProficiencyBonus(level.proficiencyBonus)
        }
        return roll
    }

    // ### saving throws

    val strengthSavingThrow = { savingThrow(StrengthSavingThrow, strength) }
    val dexteritySavingThrow = { savingThrow(DexteritySavingThrow, dexterity) }
    val constitutionSavingThrow = { savingThrow(ConstitutionSavingThrow, constitution) }
    val intelligenceSavingThrow = { savingThrow(IntelligenceSavingThrow, intelligence) }
    val wisdomSavingThrow = { savingThrow(WisdomSavingThrow, wisdom) }
    val charismaSavingThrow = { savingThrow(CharismaSavingThrow, charisma) }

    private fun savingThrow(savingThrow: SavingThrow, ability: Ability): SavingThrowRoll {
        val roll = SavingThrowRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(ability.modifier)
        if (savingThrowProficiencies.contains(savingThrow)) {
            return roll.withProficiencyBonus(level.proficiencyBonus)
        }
        return roll
    }

    // ### attacks

    fun rollAttack(): AttackRoll {
        error("asda")
    }

    // ### common rolls

    fun <T : Roll> withAdvantage(roll: () -> T): T {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll > secondRoll) firstRoll else secondRoll
    }

    fun <T : Roll> withDisadvantage(roll: () -> T): T {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll < secondRoll) firstRoll else secondRoll
    }

}
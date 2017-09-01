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

    private val abilities = mutableMapOf(
            Strength to 1,
            Dexterity to 1,
            Constitution to 1,
            Intelligence to 1,
            Wisdom to 1,
            Charisma to 1
    )

    val strength = { abilityScoreFor(Strength) }
    val dexterity = { abilityScoreFor(Dexterity) }
    val constitution = { abilityScoreFor(Constitution) }
    val intelligence = { abilityScoreFor(Intelligence) }
    val wisdom = { abilityScoreFor(Wisdom) }
    val charisma = { abilityScoreFor(Charisma) }

    private fun abilityScoreFor(ability: Ability) = AbilityScore(ability, abilities[ability]!!)

    // ### proficiencies

    val skills = mutableListOf<Skill>()

    val savingThrowProficiencies: List<SavingThrow>
        get() = characterClass.savingThrowProficiencies.toList() // might be more?

    // ### ability checks

    val strengthCheck = { abilityCheck(Strength) }
    val dexterityCheck = { abilityCheck(Dexterity) }
    val constitutionCheck = { abilityCheck(Constitution) }
    val intelligenceCheck = { abilityCheck(Intelligence) }
    val wisdomCheck = { abilityCheck(Wisdom) }
    val charismaCheck = { abilityCheck(Charisma) }

    private fun abilityCheck(ability: Ability): AbilityCheckRoll {
        val abilityScore = abilityScoreFor(ability)
        return AbilityCheckRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(abilityScore.modifier)
    }

    // ### skill checks

    val athleticsCheck = { skillCheck(Athletics) }
    val acrobaticsCheck = { skillCheck(Acrobatics) }
    val sleightOfHandCheck = { skillCheck(SleightOfHand) }
    val stealthCheck = { skillCheck(Stealth) }
    val arcanaCheck = { skillCheck(Arcana) }
    val historyCheck = { skillCheck(History) }
    val investigationCheck = { skillCheck(Investigation) }
    val natureCheck = { skillCheck(Nature) }
    val religionCheck = { skillCheck(Religion) }
    val animalHandlingCheck = { skillCheck(AnimalHandling) }
    val insightCheck = { skillCheck(Insight) }
    val medicineCheck = { skillCheck(Medicine) }
    val perceptionCheck = { skillCheck(Perception) }
    val survivalCheck = { skillCheck(Survival) }
    val deceptionCheck = { skillCheck(Deception) }
    val intimidationCheck = { skillCheck(Intimidation) }
    val performanceCheck = { skillCheck(Performance) }
    val persuasionCheck = { skillCheck(Persuasion) }

    private fun skillCheck(skill: Skill): AbilityCheckRoll {
        val abilityScore = abilityScoreFor(skill.associatedAbility)
        val roll = AbilityCheckRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(abilityScore.modifier)
        if (skills.contains(skill)) {
            return roll.withProficiencyBonus(level.proficiencyBonus)
        }
        return roll
    }

    // ### saving throws

    val strengthSavingThrow = { savingThrow(StrengthSavingThrow) }
    val dexteritySavingThrow = { savingThrow(DexteritySavingThrow) }
    val constitutionSavingThrow = { savingThrow(ConstitutionSavingThrow) }
    val intelligenceSavingThrow = { savingThrow(IntelligenceSavingThrow) }
    val wisdomSavingThrow = { savingThrow(WisdomSavingThrow) }
    val charismaSavingThrow = { savingThrow(CharismaSavingThrow) }

    private fun savingThrow(savingThrow: SavingThrow): SavingThrowRoll {
        val abilityScore = abilityScoreFor(savingThrow.associatedAbility)
        val roll = SavingThrowRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(abilityScore.modifier)
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
package de.sluit.dnd

import de.sluit.dnd.abilities.*
import de.sluit.dnd.dice.D20
import de.sluit.dnd.proficiencies.*
import de.sluit.dnd.rolls.AbilityCheckRoll
import de.sluit.dnd.rolls.Roll
import de.sluit.dnd.rolls.SavingThrowRoll

class Character(
        val name: String,
        val level: Level,
        val characterClass: CharacterClass,

        val strength: StrengthScore,
        val dexterity: DexterityScore,
        val constitution: ConstitutionScore,
        val intelligence: IntelligenceScore,
        val wisdom: WisdomScore,
        val charisma: CharismaScore,

        val skills: List<Skill>
) {

    // TODO: https://roll20.net/compendium/dnd5e/CategoryIndex%3ARules#content
    //  - Passive Checks
    //  - Any equipment (Weapons, Armor etc.) might apply modifiers to any number of properties of a character!
    //  - Characters have "Condition" effects on them applying modifiers to all kinds of properties
    //  - Movement
    //  - Race - applies modifiers on ability scores, sets base speed and adds special abilities (e.g. Darkvision)
    //  - Alignment
    //  - Languages

    private val d20 = D20()

    // ### proficiencies

    private val savingThrowProficiencies: List<Ability>
        get() = characterClass.savingThrowProficiencies.toList() // might be more?

    // ### skill checks

    val athleticsCheck = { skillCheckFor { Athletics } }
    val acrobaticsCheck = { skillCheckFor { Acrobatics } }
    val sleightOfHandCheck = { skillCheckFor { SleightOfHand } }
    val stealthCheck = { skillCheckFor { Stealth } }
    val arcanaCheck = { skillCheckFor { Arcana } }
    val historyCheck = { skillCheckFor { History } }
    val investigationCheck = { skillCheckFor { Investigation } }
    val natureCheck = { skillCheckFor { Nature } }
    val religionCheck = { skillCheckFor { Religion } }
    val animalHandlingCheck = { skillCheckFor { AnimalHandling } }
    val insightCheck = { skillCheckFor { Insight } }
    val medicineCheck = { skillCheckFor { Medicine } }
    val perceptionCheck = { skillCheckFor { Perception } }
    val survivalCheck = { skillCheckFor { Survival } }
    val deceptionCheck = { skillCheckFor { Deception } }
    val intimidationCheck = { skillCheckFor { Intimidation } }
    val performanceCheck = { skillCheckFor { Performance } }
    val persuasionCheck = { skillCheckFor { Persuasion } }

    private fun skillCheckFor(skill: () -> Skill): AbilityCheckRoll {
        val abilityScore = abilityScoreFor(abilityOf(skill))
        val roll = AbilityCheckRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(abilityScore.modifier)
        if (hasSkillProficiency(skill)) {
            return roll.withProficiencyBonus(level.proficiencyBonus)
        }
        return roll
    }

    private fun abilityOf(skillSupplier: () -> Skill) = { skillSupplier().ability }
    private fun hasSkillProficiency(skillSupplier: () -> Skill) = skills.contains(skillSupplier())

    // ### ability checks

    val strengthCheck = { abilityCheck { Strength } }
    val dexterityCheck = { abilityCheck { Dexterity } }
    val constitutionCheck = { abilityCheck { Constitution } }
    val intelligenceCheck = { abilityCheck { Intelligence } }
    val wisdomCheck = { abilityCheck { Wisdom } }
    val charismaCheck = { abilityCheck { Charisma } }

    private fun abilityCheck(ability: () -> Ability): AbilityCheckRoll {
        val abilityScore = abilityScoreFor(ability)
        return AbilityCheckRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(abilityScore.modifier)
    }

    // ### saving throws

    val strengthSavingThrow = { savingThrow { Strength } }
    val dexteritySavingThrow = { savingThrow { Dexterity } }
    val constitutionSavingThrow = { savingThrow { Constitution } }
    val intelligenceSavingThrow = { savingThrow { Intelligence } }
    val wisdomSavingThrow = { savingThrow { Wisdom } }
    val charismaSavingThrow = { savingThrow { Charisma } }

    private fun savingThrow(ability: () -> Ability): SavingThrowRoll {
        val abilityScore = abilityScoreFor(ability)
        val roll = SavingThrowRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(abilityScore.modifier)
        if (hasSavingThrowProficiency(ability)) {
            return roll.withProficiencyBonus(level.proficiencyBonus)
        }
        return roll
    }

    private fun hasSavingThrowProficiency(abilitySupplier: () -> Ability) = savingThrowProficiencies.contains(abilitySupplier())

    private fun abilityScoreFor(ability: () -> Ability): AbilityScore {
        return when (ability()) {
            is Strength -> strength
            is Dexterity -> dexterity
            is Constitution -> constitution
            is Intelligence -> intelligence
            is Wisdom -> wisdom
            is Charisma -> charisma
        }
    }

}
package de.sluit.dnd

import de.sluit.dnd.abilities.Ability
import de.sluit.dnd.abilities.Ability.*
import de.sluit.dnd.dice.Die.D20
import de.sluit.dnd.rolls.AbilityCheckRoll
import de.sluit.dnd.rolls.AttackRoll
import de.sluit.dnd.skills.Skill
import de.sluit.dnd.skills.Skill.*

class Character {

    private val d20 = D20()
    private var level = Level(1)

    // ### abilities & skills

    private var strength = Strength(1)
    private var dexterity = Dexterity(1)
    private var constitution = Constitution(1)
    private var intelligence = Intelligence(1)
    private var wisdom = Wisdom(1)
    private var charisma = Charisma(1)

    private var skills = mutableListOf<Skill>()

    // ### equipment

    private var hand: Weapon? = null

    // ### ability checks

    fun withAdvantage(roll: () -> AbilityCheckRoll): AbilityCheckRoll {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll > secondRoll) firstRoll else secondRoll
    }

    fun withDisadvantage(roll: () -> AbilityCheckRoll): AbilityCheckRoll {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll < secondRoll) firstRoll else secondRoll
    }

    fun rollAthleticsCheck() = rollSkillCheck(rollStrengthCheck(), Athletics)

    fun rollAcrobaticsCheck() = rollSkillCheck(rollDexterityCheck(), Acrobatics)
    fun rollSleightOfHandCheck() = rollSkillCheck(rollDexterityCheck(), SleightOfHand)
    fun rollStealthCheck() = rollSkillCheck(rollDexterityCheck(), Stealth)

    fun rollArcanaCheck() = rollSkillCheck(rollIntelligenceCheck(), Arcana)
    fun rollHistoryCheck() = rollSkillCheck(rollIntelligenceCheck(), History)
    fun rollInvestigationCheck() = rollSkillCheck(rollIntelligenceCheck(), Investigation)
    fun rollNatureCheck() = rollSkillCheck(rollIntelligenceCheck(), Nature)
    fun rollReligionCheck() = rollSkillCheck(rollIntelligenceCheck(), Religion)

    fun rollAnimalHandlingCheck() = rollSkillCheck(rollWisdomCheck(), AnimalHandling)
    fun rollInsightCheck() = rollSkillCheck(rollWisdomCheck(), Insight)
    fun rollMedicineCheck() = rollSkillCheck(rollWisdomCheck(), Medicine)
    fun rollPerceptionCheck() = rollSkillCheck(rollWisdomCheck(), Perception)
    fun rollSurvivalCheck() = rollSkillCheck(rollWisdomCheck(), Survival)

    fun rollDeceptionCheck() = rollSkillCheck(rollCharismaCheck(), Deception)
    fun rollIntimidationCheck() = rollSkillCheck(rollCharismaCheck(), Intimidation)
    fun rollPerformanceCheck() = rollSkillCheck(rollCharismaCheck(), Performance)
    fun rollPersuasionCheck() = rollSkillCheck(rollCharismaCheck(), Persuasion)

    private fun rollSkillCheck(abilityCheckRoll: AbilityCheckRoll, skill: Skill): AbilityCheckRoll {
        if (skills.contains(skill)) {
            val proficiencyBonus = level.proficiencyBonus
            return abilityCheckRoll.add(proficiencyBonus)
        }
        return abilityCheckRoll
    }

    fun rollStrengthCheck() = rollAbilityCheck(strength)
    fun rollDexterityCheck() = rollAbilityCheck(dexterity)
    fun rollConstitutionCheck() = rollAbilityCheck(constitution)
    fun rollIntelligenceCheck() = rollAbilityCheck(intelligence)
    fun rollWisdomCheck() = rollAbilityCheck(wisdom)
    fun rollCharismaCheck() = rollAbilityCheck(charisma)

    private fun rollAbilityCheck(ability: Ability): AbilityCheckRoll {
        val roll = d20.roll()
        val abilityModifier = ability.modifier
        return AbilityCheckRoll(roll + abilityModifier)
    }

    // ### saving throws

    fun rollSavingThrow() {

    }

    // ### attacks

    fun rollAttack(): AttackRoll {
        error("asda")
    }

}
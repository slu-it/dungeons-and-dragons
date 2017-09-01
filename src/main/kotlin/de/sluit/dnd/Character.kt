package de.sluit.dnd

import de.sluit.dnd.abilities.*
import de.sluit.dnd.dice.D20
import de.sluit.dnd.proficiencies.*
import de.sluit.dnd.rolls.AbilityCheckRoll
import de.sluit.dnd.rolls.AttackRoll
import de.sluit.dnd.rolls.SavingThrowRoll

class Character {

    // TODO
    // https://roll20.net/compendium/dnd5e/Rules:Ability%20Scores#h-Ability%20Scores
    //  - Passive Checks
    //  - Saving Throws

    private val d20 = D20()
    private var level = Level(1)
    private val characterClass: CharacterClass = Barbarian

    // ### abilities & skills

    private var strength = Strength(1)
    private var dexterity = Dexterity(1)
    private var constitution = Constitution(1)
    private var intelligence = Intelligence(1)
    private var wisdom = Wisdom(1)
    private var charisma = Charisma(1)

    private var skills = mutableListOf<Skill>()

    private val savingThrowProficiencies: List<SavingThrow>
        get() = characterClass.savingThrowProficiencies.toList()

    // ### equipment

    private var hand: Weapon? = null

    // ### ability checks

    fun abilityCheckWithAdvantage(roll: () -> AbilityCheckRoll): AbilityCheckRoll {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll > secondRoll) firstRoll else secondRoll
    }

    fun abilityCheckWithDisadvantage(roll: () -> AbilityCheckRoll): AbilityCheckRoll {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll < secondRoll) firstRoll else secondRoll
    }

    fun rollAthleticsCheck() = rollSkillCheck(Athletics, { rollStrengthCheck() })

    fun rollAcrobaticsCheck() = rollSkillCheck(Acrobatics, { rollDexterityCheck() })
    fun rollSleightOfHandCheck() = rollSkillCheck(SleightOfHand, { rollDexterityCheck() })
    fun rollStealthCheck() = rollSkillCheck(Stealth, { rollDexterityCheck() })

    fun rollArcanaCheck() = rollSkillCheck(Arcana, { rollIntelligenceCheck() })
    fun rollHistoryCheck() = rollSkillCheck(History, { rollIntelligenceCheck() })
    fun rollInvestigationCheck() = rollSkillCheck(Investigation, { rollIntelligenceCheck() })
    fun rollNatureCheck() = rollSkillCheck(Nature, { rollIntelligenceCheck() })
    fun rollReligionCheck() = rollSkillCheck(Religion, { rollIntelligenceCheck() })

    fun rollAnimalHandlingCheck() = rollSkillCheck(AnimalHandling, { rollWisdomCheck() })
    fun rollInsightCheck() = rollSkillCheck(Insight, { rollWisdomCheck() })
    fun rollMedicineCheck() = rollSkillCheck(Medicine, { rollWisdomCheck() })
    fun rollPerceptionCheck() = rollSkillCheck(Perception, { rollWisdomCheck() })
    fun rollSurvivalCheck() = rollSkillCheck(Survival, { rollWisdomCheck() })

    fun rollDeceptionCheck() = rollSkillCheck(Deception, { rollCharismaCheck() })
    fun rollIntimidationCheck() = rollSkillCheck(Intimidation, { rollCharismaCheck() })
    fun rollPerformanceCheck() = rollSkillCheck(Performance, { rollCharismaCheck() })
    fun rollPersuasionCheck() = rollSkillCheck(Persuasion, { rollCharismaCheck() })

    private fun rollSkillCheck(skill: Skill, abilityCheckRoll: () -> AbilityCheckRoll): AbilityCheckRoll {
        val roll = abilityCheckRoll()
        if (skills.contains(skill)) {
            return roll.withProficiencyBonus(level.proficiencyBonus)
        }
        return roll
    }

    fun rollStrengthCheck() = rollAbilityCheck(strength)
    fun rollDexterityCheck() = rollAbilityCheck(dexterity)
    fun rollConstitutionCheck() = rollAbilityCheck(constitution)
    fun rollIntelligenceCheck() = rollAbilityCheck(intelligence)
    fun rollWisdomCheck() = rollAbilityCheck(wisdom)
    fun rollCharismaCheck() = rollAbilityCheck(charisma)

    private fun rollAbilityCheck(ability: Ability): AbilityCheckRoll {
        return AbilityCheckRoll()
                .withRoll(d20.roll())
                .withAbilityModifier(ability.modifier)
    }

    // ### saving throws

    fun savingThrowWithAdvantage(roll: () -> SavingThrowRoll): SavingThrowRoll {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll > secondRoll) firstRoll else secondRoll
    }

    fun savingThrowWithDisadvantage(roll: () -> SavingThrowRoll): SavingThrowRoll {
        val (firstRoll, secondRoll) = Pair(roll(), roll())
        return if (firstRoll < secondRoll) firstRoll else secondRoll
    }

    fun rollStrengthSavingThrow() = rollSavingThrow(StrengthSavingThrow, strength)
    fun rollDexteritySavingThrow() = rollSavingThrow(DexteritySavingThrow, dexterity)
    fun rollConstitutionSavingThrow() = rollSavingThrow(ConstitutionSavingThrow, constitution)
    fun rollIntelligenceSavingThrow() = rollSavingThrow(IntelligenceSavingThrow, intelligence)
    fun rollWisdomSavingThrow() = rollSavingThrow(WisdomSavingThrow, wisdom)
    fun rollCharismaSavingThrow() = rollSavingThrow(CharismaSavingThrow, charisma)

    private fun rollSavingThrow(savingThrow: SavingThrow, ability: Ability): SavingThrowRoll {
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

}
package de.sluit.dnd.rolls

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AbilityCheckRollTest {

    @Test fun `total is calculated correctly`() {
        val abilityCheckRoll = AbilityCheckRoll(roll = 1, abilityModifier = 10, proficiencyBonus = 100)
        assertThat(abilityCheckRoll.total).isEqualTo(111)
    }

    @Test fun `changing the roll value returns new instance`() {
        val originalRoll = AbilityCheckRoll(roll = 1, abilityModifier = 10, proficiencyBonus = 100)
        val changedRoll = originalRoll.withRoll(2)
        assertThat(changedRoll).isNotSameAs(originalRoll)
        assertThat(changedRoll.total).isEqualTo(112)
    }

    @Test fun `changing the ability modifier value returns new instance`() {
        val originalRoll = AbilityCheckRoll(roll = 1, abilityModifier = 10, proficiencyBonus = 100)
        val changedRoll = originalRoll.withAbilityModifier(20)
        assertThat(changedRoll).isNotSameAs(originalRoll)
        assertThat(changedRoll.total).isEqualTo(121)
    }

    @Test fun `changing the proficiency bonus value returns new instance`() {
        val originalRoll = AbilityCheckRoll(roll = 1, abilityModifier = 10, proficiencyBonus = 100)
        val changedRoll = originalRoll.withProficiencyBonus(200)
        assertThat(changedRoll).isNotSameAs(originalRoll)
        assertThat(changedRoll.total).isEqualTo(211)
    }

}
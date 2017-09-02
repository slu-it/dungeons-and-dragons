package de.sluit.dnd

import de.sluit.dnd.abilities.*
import de.sluit.dnd.proficiencies.AnimalHandling
import de.sluit.dnd.proficiencies.Athletics
import de.sluit.dnd.proficiencies.Intimidation
import de.sluit.dnd.proficiencies.Survival
import de.sluit.dnd.rolls.withAdvantage
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CharacterTest {

    val grog = Character(
            name = "Grog Strongjaw",
            level = Level(15),
            characterClass = Barbarian,

            strength = StrengthScore(24),
            dexterity = DexterityScore(15),
            constitution = ConstitutionScore(20),
            intelligence = IntelligenceScore(6),
            wisdom = WisdomScore(10),
            charisma = CharismaScore(13),

            skills = listOf(AnimalHandling, Athletics, Intimidation, Survival)
    )

    @Nested inner class `saving throws are calculated correctly` {

        @Test fun `strength`() {
            val savingThrow = grog.strengthSavingThrow()
            assertThat(savingThrow.roll).isBetween(1, 20)
            assertThat(savingThrow.abilityModifier).isEqualTo(7)
            assertThat(savingThrow.proficiencyBonus).isEqualTo(5)
        }

        @Test fun `dexterity`() {
            val savingThrow = grog.dexteritySavingThrow()
            assertThat(savingThrow.roll).isBetween(1, 20)
            assertThat(savingThrow.abilityModifier).isEqualTo(2)
            assertThat(savingThrow.proficiencyBonus).isEqualTo(0)
        }

        @Test fun `constitution`() {
            val savingThrow = grog.constitutionSavingThrow()
            assertThat(savingThrow.roll).isBetween(1, 20)
            assertThat(savingThrow.abilityModifier).isEqualTo(5)
            assertThat(savingThrow.proficiencyBonus).isEqualTo(5)
        }

        @Test fun `intelligence`() {
            val savingThrow = grog.intelligenceSavingThrow()
            assertThat(savingThrow.roll).isBetween(1, 20)
            assertThat(savingThrow.abilityModifier).isEqualTo(-2)
            assertThat(savingThrow.proficiencyBonus).isEqualTo(0)
        }

        @Test fun `wisdom`() {
            val savingThrow = grog.wisdomSavingThrow()
            assertThat(savingThrow.roll).isBetween(1, 20)
            assertThat(savingThrow.abilityModifier).isEqualTo(0)
            assertThat(savingThrow.proficiencyBonus).isEqualTo(0)
        }

        @Test fun `charisma`() {
            val savingThrow = grog.charismaSavingThrow()
            assertThat(savingThrow.roll).isBetween(1, 20)
            assertThat(savingThrow.abilityModifier).isEqualTo(1)
            assertThat(savingThrow.proficiencyBonus).isEqualTo(0)
        }

    }

}
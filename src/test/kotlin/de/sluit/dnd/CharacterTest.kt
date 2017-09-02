package de.sluit.dnd

import de.sluit.dnd.abilities.*
import de.sluit.dnd.proficiencies.AnimalHandling
import de.sluit.dnd.proficiencies.Athletics
import de.sluit.dnd.proficiencies.Intimidation
import de.sluit.dnd.proficiencies.Survival
import org.assertj.core.api.Assertions.assertThat
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

    @Nested inner class `skill checks are calculated correctly` {

        @Nested inner class `strength based` {

            @Test fun `athletics`() {
                val check = grog.athleticsCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(7)
                assertThat(check.proficiencyBonus).isEqualTo(5)
            }

        }

        @Nested inner class `dexterity based` {

            @Test fun `acrobatics`() {
                val check = grog.acrobaticsCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `sleight of hand`() {
                val check = grog.sleightOfHandCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `stealth`() {
                val check = grog.stealthCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

        }

        @Nested inner class `intelligence based` {

            @Test fun `arcana`() {
                val check = grog.arcanaCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(-2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `history`() {
                val check = grog.historyCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(-2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `investigation`() {
                val check = grog.investigationCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(-2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `nature`() {
                val check = grog.natureCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(-2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `religion`() {
                val check = grog.religionCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(-2)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

        }

        @Nested inner class `wisdom based` {

            @Test fun `animal handling`() {
                val check = grog.animalHandlingCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(0)
                assertThat(check.proficiencyBonus).isEqualTo(5)
            }

            @Test fun `insight`() {
                val check = grog.insightCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(0)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `medicine`() {
                val check = grog.medicineCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(0)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `perception`() {
                val check = grog.perceptionCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(0)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `survival`() {
                val check = grog.survivalCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(0)
                assertThat(check.proficiencyBonus).isEqualTo(5)
            }

        }

        @Nested inner class `charm based` {

            @Test fun `deception`() {
                val check = grog.deceptionCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(1)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `intimidation`() {
                val check = grog.intimidationCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(1)
                assertThat(check.proficiencyBonus).isEqualTo(5)
            }

            @Test fun `performance`() {
                val check = grog.performanceCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(1)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

            @Test fun `persuasion`() {
                val check = grog.persuasionCheck()
                assertThat(check.roll).isBetween(1, 20)
                assertThat(check.abilityModifier).isEqualTo(1)
                assertThat(check.proficiencyBonus).isEqualTo(0)
            }

        }

    }

}
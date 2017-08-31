package de.sluit.dnd

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LevelTest {

    @ValueSource(ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    @ParameterizedTest(name = "a level of <{0}> is allowed")
    fun `a character's level can be any value between 1 and 20`(levelValue: Int) {
        Level(levelValue) // no exception >> test passed
    }

    @ValueSource(ints = intArrayOf(0, 21))
    @ParameterizedTest(name = "a level of <{0}> is not allowed")
    fun `a character's level must be between 1 and 20`(levelValue: Int) {
        assertThrows(IllegalStateException::class.java, {
            Level(levelValue)
        })
    }

    @CsvSource(
            "1, 2", "2, 2", "3, 2", "4, 2",
            "5, 3", "6, 3", "7, 3", "8, 3",
            "9, 4", "10, 4", "11, 4", "12, 4",
            "13, 5", "14, 5", "15, 5", "16, 5",
            "17, 6", "18, 6", "19, 6", "20, 6"
    )
    @ParameterizedTest(name = "given a level of <{0}>, the proficiency bonus will be <{1}>")
    fun `depending on the level the proficiency bonus is calculated correctly`(levelValue: Int, expectedProficiencyBonus: Int) {
        val level = Level(levelValue)
        val proficiencyBonus = level.proficiencyBonus
        assertThat(proficiencyBonus).isEqualTo(expectedProficiencyBonus)
    }

}
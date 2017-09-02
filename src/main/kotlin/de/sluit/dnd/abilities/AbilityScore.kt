package de.sluit.dnd.abilities


data class StrengthScore(override val score: Int) : AbilityScore()
data class DexterityScore(override val score: Int) : AbilityScore()
data class ConstitutionScore(override val score: Int) : AbilityScore()
data class IntelligenceScore(override val score: Int) : AbilityScore()
data class WisdomScore(override val score: Int) : AbilityScore()
data class CharismaScore(override val score: Int) : AbilityScore()

sealed class AbilityScore {

    abstract val score: Int

    val modifier: Int
        get() = Math.floor((score - 10.0) / 2.0).toInt()

}

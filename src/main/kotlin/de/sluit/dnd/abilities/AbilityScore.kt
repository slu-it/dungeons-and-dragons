package de.sluit.dnd.abilities

data class AbilityScore(
        val score: Int
) {

    val modifier: Int
        get() = Math.floor((score - 10.0) / 2.0).toInt()

}

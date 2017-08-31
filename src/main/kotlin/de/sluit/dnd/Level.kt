package de.sluit.dnd

class Level(
        private val value: Int
) {

    init {
        if (value < 1 || value > 20)
            error("A character's level must be between <1> and <20>!")
    }

    val proficiencyBonus: Int
        get() = when (value) {
            in 1..4 -> +2
            in 5..8 -> +3
            in 9..12 -> +4
            in 13..16 -> +5
            in 16..20 -> +6
            else -> error("illegal level value")
        }

}
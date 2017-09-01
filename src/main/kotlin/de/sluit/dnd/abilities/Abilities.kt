package de.sluit.dnd.abilities

class Strength(score: Int) : Ability(score)
class Dexterity(score: Int) : Ability(score)
class Constitution(score: Int) : Ability(score)
class Intelligence(score: Int) : Ability(score)
class Wisdom(score: Int) : Ability(score)
class Charisma(score: Int) : Ability(score)

sealed class Ability(
        val score: Int
) {

    val modifier: Int
        get() = Math.floor((score - 10.0) / 2.0).toInt()

}

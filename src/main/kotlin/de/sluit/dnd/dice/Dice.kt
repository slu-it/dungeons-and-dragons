package de.sluit.dnd.dice

class Dice(
        die: Die,
        vararg additionalDice: Die
) {

    private val dice: Array<Die> = arrayOf(die, *additionalDice)

    fun roll(): Int = dice.sumBy { it.roll() }

}

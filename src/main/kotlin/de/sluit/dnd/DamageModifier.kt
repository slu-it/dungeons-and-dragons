package de.sluit.dnd

import de.sluit.dnd.rolls.DamageRoll

sealed class DamageModifier(
        private val value: Int
) {

    object Default : DamageModifier(0)
    object PlusOne : DamageModifier(+1)
    object PlusTwo : DamageModifier(+2)
    object PlusThree : DamageModifier(+3)

    fun apply(damageRoll: DamageRoll): DamageRoll = damageRoll.add(value)

}
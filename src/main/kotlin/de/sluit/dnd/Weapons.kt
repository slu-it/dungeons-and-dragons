package de.sluit.dnd

import de.sluit.dnd.DamageType.Piercing
import de.sluit.dnd.DamageType.Slashing
import de.sluit.dnd.dice.D10
import de.sluit.dnd.dice.D4
import de.sluit.dnd.dice.D8
import de.sluit.dnd.dice.Dice
import de.sluit.dnd.rolls.AttackRoll
import de.sluit.dnd.rolls.DamageRoll


class Battleaxe : Weapon(
        name = "Battleaxe",
        oneHandedDamage = Damage(Dice(D8()), Slashing),
        twoHandedDamage = Damage(Dice(D10()), Slashing)
)

class Dagger : Weapon(
        name = "Dagger",
        oneHandedDamage = Damage(Dice(D4()), Piercing)
)

class Longsword : Weapon(
        name = "Longsword",
        oneHandedDamage = Damage(Dice(D8()), Slashing),
        twoHandedDamage = Damage(Dice(D10()), Slashing)
)

class LongswordPlusOne : Weapon(
        name = "Longsword +1",
        damageModifier = DamageModifier.PlusOne,
        oneHandedDamage = Damage(Dice(D8()), Slashing),
        twoHandedDamage = Damage(Dice(D10()), Slashing)
)

abstract class Weapon(
        val name: String,
        val damageModifier: DamageModifier = DamageModifier.Default,
        val oneHandedDamage: Damage? = null,
        val twoHandedDamage: Damage? = null
) {

    init {
        if (oneHandedDamage == null && twoHandedDamage == null)
            error("weapon needs to have at at least one damage type set")
    }

    fun rollOneHandedDamage(): DamageRoll {
        if (oneHandedDamage == null) error("'$name' can't be used one-handed")
        return rollDamage(oneHandedDamage)
    }

    fun rollTwoHandedDamage(): DamageRoll {
        if (twoHandedDamage == null) error("'$name' can't be used two-handed")
        return rollDamage(twoHandedDamage)
    }

    private fun rollDamage(damage: Damage): DamageRoll {
        val dice = damage.dice
        val damageRole = DamageRoll(dice.roll())
        return damageModifier.apply(damageRole)
    }

}

sealed class WeaponProperty {

    open fun applyToAttackRoll(attackRoll: AttackRoll): AttackRoll {
        return attackRoll
    }

    open fun applyToDamageRoll(damageRoll: DamageRoll): DamageRoll {
        return damageRoll
    }

}

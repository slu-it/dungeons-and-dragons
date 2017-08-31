package de.sluit.dnd

sealed class DamageType {
    object Acid : DamageType()
    object Bludgeoning : DamageType()
    object Cold : DamageType()
    object Fire : DamageType()
    object Force : DamageType()
    object Lightning : DamageType()
    object Necrotic : DamageType()
    object Piercing : DamageType()
    object Poison : DamageType()
    object Psychic : DamageType()
    object Radiant : DamageType()
    object Slashing : DamageType()
    object Thunder : DamageType()
}
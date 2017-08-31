package de.sluit.dnd.skills

sealed class Skill {

    // strength

    object Athletics : Skill()

    // dexterity

    object Acrobatics : Skill()
    object SleightOfHand : Skill()
    object Stealth : Skill()

    // intelligence

    object Arcana : Skill()
    object History : Skill()
    object Investigation : Skill()
    object Nature : Skill()
    object Religion : Skill()

    // wisdom

    object AnimalHandling : Skill()
    object Insight : Skill()
    object Medicine : Skill()
    object Perception : Skill()
    object Survival : Skill()

    // charisma

    object Deception : Skill()
    object Intimidation : Skill()
    object Performance : Skill()
    object Persuasion : Skill()

}
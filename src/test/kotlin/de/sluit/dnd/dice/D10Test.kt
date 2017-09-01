package de.sluit.dnd.dice

class D10Test : DieContract {
    override fun getTestInstance() = D10()
    override val numberOfSides = 10
}
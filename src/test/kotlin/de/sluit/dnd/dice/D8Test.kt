package de.sluit.dnd.dice

class D8Test : DieContract {
    override fun getTestInstance() = D8()
    override val numberOfSides = 8
}
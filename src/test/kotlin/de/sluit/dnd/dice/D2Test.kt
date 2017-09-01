package de.sluit.dnd.dice

class D2Test : DieContract {
    override fun getTestInstance() = D2()
    override val numberOfSides = 2
}
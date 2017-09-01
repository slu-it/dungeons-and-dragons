package de.sluit.dnd.dice

class D4Test : DieContract {
    override fun getTestInstance() = D4()
    override val numberOfSides = 4
}
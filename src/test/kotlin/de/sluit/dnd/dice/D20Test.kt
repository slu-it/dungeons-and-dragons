package de.sluit.dnd.dice

class D20Test : DieContract {
    override fun getTestInstance() = D20()
    override val numberOfSides = 20
}
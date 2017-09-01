package de.sluit.dnd.dice

class D100Test : DieContract {
    override fun getTestInstance() = D100()
    override val numberOfSides = 100
}
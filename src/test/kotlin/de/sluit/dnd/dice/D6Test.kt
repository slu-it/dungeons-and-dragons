package de.sluit.dnd.dice

class D6Test : DieContract {
    override fun getTestInstance() = D6()
    override val numberOfSides = 6
}
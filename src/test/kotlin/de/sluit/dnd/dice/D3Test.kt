package de.sluit.dnd.dice

class D3Test : DieContract {
    override fun getTestInstance() = D3()
    override val numberOfSides = 3
}
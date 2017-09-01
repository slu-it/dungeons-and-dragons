package de.sluit.dnd.dice

class D12Test : DieContract {
    override fun getTestInstance() = D12()
    override val numberOfSides = 12
}
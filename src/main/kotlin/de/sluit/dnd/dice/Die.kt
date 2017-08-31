package de.sluit.dnd.dice

import java.util.*

sealed class Die(
        private val numberOfSides: Int
) {

    private val random: Random = Random()

    open fun roll(): Int = random.nextInt(numberOfSides) + 1

    class D20 : Die(20)
    class D12 : Die(12)
    class D10 : Die(10)
    class D8 : Die(8)
    class D6 : Die(6)
    class D4 : Die(4)
    class D3 : Die(3)

}
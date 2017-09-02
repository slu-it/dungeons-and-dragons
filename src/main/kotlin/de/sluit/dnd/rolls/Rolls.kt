package de.sluit.dnd.rolls


fun <T : Roll> withAdvantage(roll: () -> T): T {
    val firstRoll = roll()
    val secondRoll = roll()
    val result = if (firstRoll > secondRoll) firstRoll else secondRoll
    logRollWithAdvantage(firstRoll, secondRoll, result)
    return result
}

private fun <T : Roll> logRollWithAdvantage(firstRoll: T, secondRoll: T, result: T) {
    println("rolling with advantage:")
    println(" - first roll : $firstRoll")
    println(" - second roll: $secondRoll")
    println("taking: $result")
}

fun <T : Roll> withDisadvantage(roll: () -> T): T {
    val firstRoll = roll()
    val secondRoll = roll()
    val result = if (firstRoll < secondRoll) firstRoll else secondRoll
    logRollWithDisadvantage(firstRoll, secondRoll, result)
    return result
}

private fun <T : Roll> logRollWithDisadvantage(firstRoll: T, secondRoll: T, result: T) {
    println("rolling with disadvantage:")
    println(" - first roll : $firstRoll")
    println(" - second roll: $secondRoll")
    println("taking: $result")
}

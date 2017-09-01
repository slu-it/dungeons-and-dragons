package de.sluit.dnd.rolls

interface Roll : Comparable<Roll> {

    val total: Int

    override fun compareTo(other: Roll): Int = total.compareTo(other.total)

}
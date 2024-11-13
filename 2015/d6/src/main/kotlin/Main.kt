package org.example

import LightsGrid
import LightsGridImproved

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    val readText = Thread.currentThread().contextClassLoader.getResource("input")?.readText()
    part2(readText)

}

private fun part1(readText: String?) {
    val lightsGrid = LightsGrid(1000)
    val regex = """(\w+).(\d+),(\d+) \w+ (\d+),(\d+)""".toRegex()

    for (s in readText!!.split("\n")) {
        val find = regex.find(s)
        var command = find!!.groups[1]!!.value
        var rowStart = find.groups[2]!!.value.toInt()
        var collumnStart = find.groups[3]!!.value.toInt()
        var rowEnd = find.groups[4]!!.value.toInt()
        var collumnEnd = find.groups[5]!!.value.toInt()

        when (command) {
            "on" -> lightsGrid.turnOnCluster(rowStart, collumnStart, rowEnd, collumnEnd)
            "off" -> lightsGrid.turnOffCluster(rowStart, collumnStart, rowEnd, collumnEnd)
            "toggle" -> lightsGrid.toggleCluster(rowStart, collumnStart, rowEnd, collumnEnd)
        }
    }
    println(lightsGrid.count())
}

private fun part2(readText: String?) {
    val lightsGrid = LightsGridImproved(1000)
    val regex = """(\w+).(\d+),(\d+) \w+ (\d+),(\d+)""".toRegex()

    for (s in readText!!.split("\n")) {
        val find = regex.find(s)
        var command = find!!.groups[1]!!.value
        var rowStart = find.groups[2]!!.value.toInt()
        var collumnStart = find.groups[3]!!.value.toInt()
        var rowEnd = find.groups[4]!!.value.toInt()
        var collumnEnd = find.groups[5]!!.value.toInt()

        when (command) {
            "on" -> lightsGrid.turnOnCluster(rowStart, collumnStart, rowEnd, collumnEnd)
            "off" -> lightsGrid.turnOffCluster(rowStart, collumnStart, rowEnd, collumnEnd)
            "toggle" -> lightsGrid.toggleCluster(rowStart, collumnStart, rowEnd, collumnEnd)
        }
    }
    println(lightsGrid.count())
}
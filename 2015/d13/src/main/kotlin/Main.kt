package org.example

import AllCombination.choose

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    val input = """
Alice would lose 2 happiness units by sitting next to Bob.
Alice would lose 62 happiness units by sitting next to Carol.
Alice would gain 65 happiness units by sitting next to David.
Alice would gain 21 happiness units by sitting next to Eric.
Alice would lose 81 happiness units by sitting next to Frank.
Alice would lose 4 happiness units by sitting next to George.
Alice would lose 80 happiness units by sitting next to Mallory.
Bob would gain 93 happiness units by sitting next to Alice.
Bob would gain 19 happiness units by sitting next to Carol.
Bob would gain 5 happiness units by sitting next to David.
Bob would gain 49 happiness units by sitting next to Eric.
Bob would gain 68 happiness units by sitting next to Frank.
Bob would gain 23 happiness units by sitting next to George.
Bob would gain 29 happiness units by sitting next to Mallory.
Carol would lose 54 happiness units by sitting next to Alice.
Carol would lose 70 happiness units by sitting next to Bob.
Carol would lose 37 happiness units by sitting next to David.
Carol would lose 46 happiness units by sitting next to Eric.
Carol would gain 33 happiness units by sitting next to Frank.
Carol would lose 35 happiness units by sitting next to George.
Carol would gain 10 happiness units by sitting next to Mallory.
David would gain 43 happiness units by sitting next to Alice.
David would lose 96 happiness units by sitting next to Bob.
David would lose 53 happiness units by sitting next to Carol.
David would lose 30 happiness units by sitting next to Eric.
David would lose 12 happiness units by sitting next to Frank.
David would gain 75 happiness units by sitting next to George.
David would lose 20 happiness units by sitting next to Mallory.
Eric would gain 8 happiness units by sitting next to Alice.
Eric would lose 89 happiness units by sitting next to Bob.
Eric would lose 69 happiness units by sitting next to Carol.
Eric would lose 34 happiness units by sitting next to David.
Eric would gain 95 happiness units by sitting next to Frank.
Eric would gain 34 happiness units by sitting next to George.
Eric would lose 99 happiness units by sitting next to Mallory.
Frank would lose 97 happiness units by sitting next to Alice.
Frank would gain 6 happiness units by sitting next to Bob.
Frank would lose 9 happiness units by sitting next to Carol.
Frank would gain 56 happiness units by sitting next to David.
Frank would lose 17 happiness units by sitting next to Eric.
Frank would gain 18 happiness units by sitting next to George.
Frank would lose 56 happiness units by sitting next to Mallory.
George would gain 45 happiness units by sitting next to Alice.
George would gain 76 happiness units by sitting next to Bob.
George would gain 63 happiness units by sitting next to Carol.
George would gain 54 happiness units by sitting next to David.
George would gain 54 happiness units by sitting next to Eric.
George would gain 30 happiness units by sitting next to Frank.
George would gain 7 happiness units by sitting next to Mallory.
Mallory would gain 31 happiness units by sitting next to Alice.
Mallory would lose 32 happiness units by sitting next to Bob.
Mallory would gain 95 happiness units by sitting next to Carol.
Mallory would gain 91 happiness units by sitting next to David.
Mallory would lose 66 happiness units by sitting next to Eric.
Mallory would lose 75 happiness units by sitting next to Frank.
Mallory would lose 99 happiness units by sitting next to George.      
    """.trimIndent()
    // boolean is switch for part 1 and 2
    val m = parseSittingMap(input, true)
    println(m)
    val table = Table()
    print(table.getTotalHappiness(m))
    var l = ArrayList<String>()
    m.forEach { k, v -> l.add(k) }
    val choose = choose(l, l.size)
    var maxHappiness = Int.MIN_VALUE
    for (strings in choose) {
        table.addAll(strings)
        val totalHappiness = table.getTotalHappiness(m)
        if (totalHappiness > maxHappiness){
            maxHappiness = totalHappiness
        }
        table.a.clear()
    }
    println(maxHappiness)



}

private fun parseSittingMap(input: String, includeMe: Boolean):
    HashMap<String, HashMap<String, Int>> {
    val m = HashMap<String, HashMap<String, Int>>()
    val reg = "^(\\w+) \\w+ (\\w+) (\\w+) \\w+ \\w+ \\w+ \\w+ \\w+ \\w+ (\\w+)".toRegex()
    for (s in input.split("\n")) {
        val find = reg.find(s)
        val who = find!!.groups[1]!!.value
        val tag = find!!.groups[2]!!.value
        var value = find!!.groups[3]!!.value
        val next = find!!.groups[4]!!.value

        val inner = HashMap<String, Int>()
        if (tag.equals("lose")) {
            value = "-" + value
        }
        inner.put(next, value.toInt())

        if (!m.contains(who)) {
            m.put(who, inner)
        } else {
            m.get(who)!!.put(next, value.toInt())
        }
    }

    if (includeMe){
        val toList = m.map { e -> e.key }.toList()
        val inner = HashMap<String, Int>()
        for (s in toList) {
            // add relation of me to others
            if (!m.contains("me")) {
                inner.put(s, 0)
                m.put("me", inner)
            } else {
                m.get("me")!!.put(s, 0)
            }
            // add to others relation to me
            m.get(s)!!.put("me",0)
        }
    }
    return m
}
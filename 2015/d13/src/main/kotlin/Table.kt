package org.example

class Table {
    var a = ArrayList<String>()

    fun setArray(a :ArrayList<String>){
        this.a = a
    }

    private fun getNeighbours(i: Int): Pair<String, String> {
        val n = a.size - 1
        if (i == 0) {
            return Pair(a[n ], a[i + 1])
        }
        if (i == n) {
            return Pair(a[i - 1], a[0])
        }
        return Pair(a[i - 1], a[i + 1])
    }

    fun getTotalHappiness(m : HashMap<String, HashMap<String, Int>>): Int {
        var i = 0
        var sum = 0
        println(a)
        while(i <= a.size-1){
            val neighbours = getNeighbours(i)
            val who = a[i]
            println("sit " + who)
            sum += m.get(who)?.get(neighbours.first) ?: 0
            println(neighbours.first + " " + m.get(who)?.get(neighbours.first))
            sum += m.get(who)?.get(neighbours.second) ?: 0
            println(neighbours.second + " " + m.get(who)?.get(neighbours.second))
            println()
            i++
        }
        return sum
    }

    fun addAll(m: MutableList<String>) {
        m.forEach { e -> a.add(e) }
    }
}
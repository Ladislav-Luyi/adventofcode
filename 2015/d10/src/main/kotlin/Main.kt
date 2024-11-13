package org.example

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    val n = 50
    var i = 0
    var input = "1113222113"
    while (i < n){
        input = process(input)
        i++
    }
    println(input)
    println(input.length)

}

fun process(input: String): String {
    val a = input.toCharArray()
    var i = 1
    var counter = 1
    var r = StringBuilder()
    while (i < a.size ){
        val current = a[i]
        val previous = a[i -1]
        if (current == previous){
            counter++
        }
        if (current != previous) {
            r.append(counter)
            r.append(previous)
            counter = 1
        }
        if (i == a.size - 1){
            r.append(counter)
            r.append(current)
        }
        i++
//        println("iter " + r)
    }
    return r.toString()
}

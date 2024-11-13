package org.example

fun main() {
    val name = """
        {"e":{"a":{"e":-39,"c":119,"a":{"c":65,"a":"orange","b":"green","d":"orange"},"g":"violet","b":{"e":6,"c":,"a":"violet","b":,"d":{"e":"violet","a":"blue","d":"blue","c":"blue","h":"orange","b":,"g":173,"f":["orange","green",54,-9],"i":-23},"f":{"c":110,"a":"yellow","b":[{"a":155},156,"violet",94,"yellow"],"d":}},"b":[[{"c":0,"a":108,"b":"green","d":,"a":{"e":[{"e":["yellow"],"c":93,"a":"violet","b":{"a":{"a":"yellow","b":"blue"},"b":-4},"d":"violet"},171,103,[13,"orange",[[51,"violet","yellow",{"c":85,"a":103,"b":"green"},97,{"e":"orange","a":-11,"d":62,"j":"yellow","c":"orange","h":47,"b":83,"g":119,"f":180,"i":136},{"a":177},80],{"e":],{"e":["orange",42,["orange",197,"violet","yellow","blue",11,"yellow"],189,"yellow","blue","green","violet"],"a":,{"e":{"c":40,"a":"orange","b":"green"},"c":"green","a":-44,"b":{"e":"blue","c":56,"a":"yellow","g":62,"b":188,"d":141,"f":-21},"d":"yellow","f":,"d":{"c":"green","a":52,"b":[136,{"c":,"a":"violet","b":{"a":{"e":172,"c":171,"a":"yellow","b":191,"d":}},"d":[86,-11,-5,["orange","green",64,["blue",15,"orange","yellow","violet",181,"green","blue"],"yellow","yellow",{"e":27,"c":156,"a":"blue","g":"violet","b":38,"d":51,"f":23},"orange","violet"],10]},[55,{"e":191,"c":"blue","a":"orange","b":"yellow","d":109},"blue",,"c":"blue","h":[[19],"orange",[{"e":["yellow",68,28,29,,38,28,65,],"a":"orange","d":129,"c":33,"h":"violet","b":"orange","g":"green","f":-24},["violet",-22],[64,-20,
    """.trimIndent()

    var i = 0
    val n = name.length - 1
    var sum = 0
    val toCharArray = name.toCharArray();
    var sb = StringBuilder()
    var isQuote  = false
    var isStillDigit = false;
    while (true){
        var c = toCharArray[i]

        isQuote = checkQuote(isQuote, c)

        if (!isQuote) {
            if (c.isDigit() || c == '-') {
                isStillDigit = true
            }else{
                isStillDigit = false
            }

            if (isStillDigit) {
                sb.append(c)
            }
            if (!isStillDigit && sb.isNotEmpty()) {
                sum += sb.toString().toInt()
                sb.clear()
            }
        }
        i++

        if (i > n){
            break
        }
    }

    println(sum)


}

private fun checkQuote(isQuote: Boolean, c: Char): Boolean {
    var isQuote1 = isQuote
    if (!isQuote1 && c == '"') {
        isQuote1 = true
    } else if (isQuote1 && c == '"') {
        isQuote1 = false
    }
    return isQuote1
}
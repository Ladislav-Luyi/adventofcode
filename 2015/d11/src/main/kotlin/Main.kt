package org.example

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    var a = "hxbxxyzz";
    val toCharArray = a.toCharArray()
    var genList = mutableListOf<CharWrapper>()
    for (c in toCharArray) {
        genList.add( CharWrapper(c) )
    }
    var n =  genList.size - 1
    var i = n

//     logic for increasing
    while (true){
        if (genList[i].inc()){
            i--
            if (i < 0){
                i = n
            }
        }else{
            i = n
        }

        // means processing logic finish
        if (i == n) {
            val s = toString(genList)
            if (
                hasAtLeastThreeIncChars(genList) &&
                notContainIorOorL(s) &&
                containTwoDifferentPairs(s)
                ){
                break
            }
        }
    }
    println(toString(genList))
    }

fun hasAtLeastThreeIncChars(genList: List<CharWrapper>): Boolean {
    val windowed = genList.toList().windowed(3, 1)
    for (charWrappers in windowed) {
        if (charWrappers[0].getInt() == charWrappers[1].getInt() - 1 &&
            charWrappers[1].getInt() - 1 == charWrappers[2].getInt() - 2){
            return true
        }
    }
    return false
}

private fun toString(genList: List<CharWrapper>): String {
    var r = StringBuilder()
    for (charWrapper in genList) {
        r.append(charWrapper.ch)
    }
    return r.toString()
}

private fun notContainIorOorL(s: String): Boolean{
    if (s.contains("i") ||
        s.contains("o") ||
        s.contains("l")){
        return false
    }
    return true
}

private fun containTwoDifferentPairs(s: String): Boolean{
    val toCharArray = s.toCharArray()
    val windowed = toCharArray.toList().windowed(2, 1)
    var set = HashSet<Char>()
    var counter = 0
    for (chars in windowed.toList()) {
        if  (
                chars[0] == chars[1] &&
                ! set.contains(chars[0])
            ){
            set.add(chars[0])
            counter++
        }
    }
   if (counter >= 2){
       return true
   }
    return false
}



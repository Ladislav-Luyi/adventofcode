package org.example

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    val readText = Thread.currentThread().contextClassLoader.getResource("input")?.readText()
    readText?.let { part2(it) }
}

fun part1(s: String?){
    val strings = s?.split("\n")

    var regexBlackList = "(ab|cd|pq|xy)".toRegex()

    val toList = strings
        ?.filter { e -> !regexBlackList.containsMatchIn(e) }
        ?.filter { e -> areThereThreeVowel(e) }
        ?.filter { e -> areTwoSameCharsInRow(e) }
        ?.toList()
    println(toList?.size)
}

private fun areTwoSameCharsInRow(s: String): Boolean {
    var previous: Char? = null;
    var twoAreSame = false;
    for (ch in s.indices) {
        val current = s[ch];
        if (previous == current) {
            twoAreSame = true;
            break;
        }
        previous = current
    }
    return twoAreSame
}

private fun areThereThreeVowel(s: String): Boolean {
     var counter = 0;
    for (c in s.toCharArray()) {
        for (n in arrayOf('a', 'e', 'i', 'o', 'u')){
            if (c == n){
                counter++;
            }
            if (counter == 3){
                return true;
            }
        }
    }
    return false;
}

private fun part2(s: String){
    val strings = s.split("\n")
    val toList = strings
        .filter { e -> containAtLeastTwoPairs(e) }
        .filter { e -> containValidTriplet(e) }
        .toList()
    toList?.forEach { e-> println(e) }
    println(toList?.size)

}


private fun containAtLeastTwoPairs(s: String): Boolean {
    val r: ArrayList<String> = ArrayList()
    val hashMap = hashMapOf<String, Int>()
    var index = 1;
    for (i in s.toList().windowed(2,1)){
        val next = i[0] + "" + i[1];
        if(hashMap.contains(next) && hashMap[next] == index-1){
            // do nothing
        }
        else if (hashMap.contains(next)) {
            val substring = s.substring(hashMap[next]!!, index)
            r.add(substring)
            hashMap[next] = index
        }
        else {
                hashMap[next] = index
        }
        index+=1;
    }
    return !r.isEmpty()
}

private fun containValidTriplet(s: String): Boolean{
    val toCharArray = s.toCharArray()
    val windowed = toCharArray.toList().windowed(3, 1)
    for (chars in windowed.toList()) {
        if (chars[0] == chars[2]){
            println(chars[0] + "==" + chars[2])
            return true
        }
    }
    return false
}



package org.example

import java.security.MessageDigest

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    for (i in 1..Int.MAX_VALUE) {
        val input = "ckczppom$i"
        val md = MessageDigest.getInstance("MD5")
        val hashBytes = md.digest(input.toByteArray())
        val hexString = hashBytes.joinToString("") { "%02x".format(it) }

        if (hexString.substring(0, 6) == "000000") {
            println(hexString)
            println(input)
            break
        }
    }

}
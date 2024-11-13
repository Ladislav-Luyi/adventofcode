package org.example

class CharWrapper(var ch: Char) {

    fun getInt(): Int{
        return ch.code
    }

    fun get(): Char{
        return ch
    }

    fun inc(): Boolean{
        ch = ch.inc();
        if (ch.code > 122){
            ch = 'a'
            return true
        }else{
            return false
        }
    }

}
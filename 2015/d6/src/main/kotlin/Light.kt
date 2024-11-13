class Light {
    var brightness = 0
    fun up(){
        brightness++
    }
    fun down(){
        if (brightness > 0) {
            brightness--
        }
    }
}
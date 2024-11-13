class LightsGridImproved {
    val matrix: Array<Array<Light>>;
    val n: Int;
    constructor(int: Int){
        n = int
        matrix = Array(int) {
            Array(int) {
                Light()
            }
        }
    }

    fun print(){
        for (i in 0..n-1){
            for (j in 0..n-1){
                print(matrix[i][j])
                print(" ")
            }
            println()
        }
    }

    fun switchSingle(row: Int, col: Int, bool: Boolean){
        if (bool){
            matrix[row][col].up()
        }else{
            matrix[row][col].down()
        }
    }
    fun turnOnSingle(row: Int, col: Int){
        switchSingle(row, col, true)
    }
    fun turnOffSingle(row: Int, col: Int){
        switchSingle(row, col, false)
    }

    fun toggleSingle(row: Int, col: Int){
        turnOnSingle(row, col)
        turnOnSingle(row, col)
    }

    fun turnOnCluster(rowStart: Int, colStart: Int, rowEnd: Int, colEnd: Int){
        for (i in rowStart..rowEnd){
            for (j in colStart..colEnd){
                turnOnSingle(i, j)
            }
        }
    }


    fun turnOffCluster(rowStart: Int, colStart: Int, rowEnd: Int, colEnd: Int){
        for (i in rowStart..rowEnd){
            for (j in colStart..colEnd){
                turnOffSingle(i, j)
            }
        }
    }

    fun toggleCluster(rowStart: Int, colStart: Int, rowEnd: Int, colEnd: Int){
        for (i in rowStart..rowEnd){
            for (j in colStart..colEnd){
                toggleSingle(i, j)
            }
        }
    }

    fun count(): Int {
        var counter = 0;
        for (i in 0..n-1){
            for (j in 0..n-1){
                counter += matrix[i][j].brightness

            }
        }
        return counter
    }


}
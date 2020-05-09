/**

    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false

    Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.

 */


package week2

fun main()
{
    val coordinates1 = intArrayOf(1,2)
    val coordinates2 = intArrayOf(2,3)
    val coordinates3 = intArrayOf(3,4)
    val coordinates4 = intArrayOf(4,5)
    val coordinates5 = intArrayOf(5,6)
    val coordinates6 = intArrayOf(6,7)
    val inputArrayOfCoordinates = arrayOf(coordinates1,coordinates2,coordinates3,coordinates4,coordinates5,coordinates6)

    println(checkStraightLine(inputArrayOfCoordinates))
}

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    for (i in 2 until coordinates.size) {
        if ((coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0])
            !=
            (coordinates[1][0] - coordinates[0][0]) * (coordinates[i][1] - coordinates[0][1])
        ) return false
    }
    return true
}
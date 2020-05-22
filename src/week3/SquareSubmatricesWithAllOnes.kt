/**

    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

    Example 1:

    Input: matrix =
    [
    [0,1,1,1],
    [1,1,1,1],
    [0,1,1,1]
    ]

    Output: 15

    Explanation:
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.

    Example 2:

    Input: matrix =
    [
    [1,0,1],
    [1,1,0],
    [1,1,0]
    ]

    Output: 7

    Explanation:
    There are 6 squares of side 1.
    There is 1 square of side 2.
    Total number of squares = 6 + 1 = 7.


    Constraints:

    1 <= arr.length <= 300
    1 <= arr[0].length <= 300
    0 <= arr[i][j] <= 1
 */



package week3

import kotlin.math.min

fun main()
{
    val arr1 = intArrayOf(0,1,1,1)
    val arr2 = intArrayOf(1,1,1,1)
    val arr3 = intArrayOf(0,1,1,1)
    println(countSquares(arrayOf(arr1, arr2, arr3)))

    val arr4 = intArrayOf(1,0,1)
    val arr5 = intArrayOf(1,1,0)
    val arr6 = intArrayOf(1,1,0)
    println(countSquares(arrayOf(arr4, arr5, arr6)))

}

fun countSquares(matrix: Array<IntArray>?): Int {
    var count = 0
    if (matrix != null && matrix.isNotEmpty()) {
        val row = matrix.size
        val col: Int = matrix[0].size
        var j: Int
        val dp = Array(row + 1) { IntArray(col + 1) }
        var i = 1
        while (i <= row) {
            j = 1
            while (j <= col) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], min(dp[i][j - 1], dp[i - 1][j]))
                    count += dp[i][j]
                }
                j++
            }
            i++
        }
    }
    return count
}
/**

    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Note: Do not use any built-in library function such as sqrt.

    Example 1:

    Input: 16
    Output: true

    Example 2:

    Input: 14
    Output: false

 */


package week2

fun main()
{
    println(isPerfectSquare(16))
    println(isPerfectSquare(14))
}

fun isPerfectSquare(num: Int): Boolean {
    if (num == 0 || num == 1) return true
    var left = 0
    var right = num
    while (left <= right) {
        val mid = right - (right - left) / 2
        if (num % mid == 0 && mid == num / mid) return true else if (mid < num / mid) left = mid + 1 else right =
            mid - 1
    }
    return false
}
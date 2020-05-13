/**

    Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

    Note:
    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

    Example 1:

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    Example 2:

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

    Example 3:

    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */


package week2

import java.util.*


fun main()
{
    println(removeKdigits("1432219", 3))
    println(removeKdigits("10200", 1))
    println(removeKdigits("10", 2))
}

fun removeKdigits(num: String, k: Int): String? {
    var k = k
    val len = num.length
    if (len == k) return "0"
    var counter = 0
    val stack = Stack<Char>()
    while (counter < len) {
        val curDigit = num[counter]
        while (!stack.isEmpty() && stack.peek() > curDigit && k > 0) {
            stack.pop()
            --k
        }
        stack.push(curDigit)
        counter++
    }
    while (k > 0) {
        stack.pop()
        --k
    }
    val stringBuilder = StringBuilder()
    while (!stack.isEmpty()) {
        stringBuilder.append(stack.pop())
    }
    stringBuilder.reverse()
    while (stringBuilder.length > 1 && stringBuilder[0] == '0') {
        stringBuilder.deleteCharAt(0)
    }
    return stringBuilder.toString()
}
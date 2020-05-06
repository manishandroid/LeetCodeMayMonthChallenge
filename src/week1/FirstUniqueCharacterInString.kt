/**

    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:

    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.

    Note: You may assume the string contain only lowercase letters.

 */


package week1

fun main()
{
    println(firstUniqueChar("loveleetcode"))
}

fun firstUniqueChar(s: String?): Int {
    var count = -1
    if (s == null || s.isEmpty()) {
        return -1
    } else if (s.length == 1) {
        return 0
    }
    for (ch in s.toCharArray()) {
        if (s.indexOf(ch) == s.lastIndexOf(ch)) {
            count = s.indexOf(ch)
            break
        }
    }
    return count
}
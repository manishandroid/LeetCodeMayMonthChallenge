/**

    Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

    Example 1:

    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:

    Input:s1= "ab" s2 = "eidboaoo"
    Output: False


    Note:

    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].

 */


package week3

fun main()
{
    println(checkInclusion("ab", "eidbaooo"))
    println(checkInclusion("ab", "eidboaoo"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val count = IntArray(128)
    for (c in s1.toCharArray())
        count[c.toInt()]++
    var start = 0
    var end = 0
    while (end < s2.length)
    {
        count[s2[end].toInt()]--
        while (count[s2[end].toInt()] < 0)
        {
            count[s2[start++].toInt()]++
        }
        if (end - start + 1 == s1.length)
            return true
        end++
    }
    return false
}
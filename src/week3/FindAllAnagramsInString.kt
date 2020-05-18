/**

    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

    The order of output does not matter.

    Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
    [0, 1, 2]

    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".

 */


package week3

fun main()
{
    println(findAnagrams("cbaebabacd", "abc"))
    println(findAnagrams("abab", "ab"))
}

fun findAnagrams(s: String?, p: String?): List<Int>? {
    val anagrams: MutableList<Int> = ArrayList()
    if (p == null || s == null || s.isEmpty() || p.isEmpty())
        return anagrams
    val target = IntArray(26)
    for (element in p) {
        target[element - 'a']++
    }
    val sb = StringBuilder()
    val hops = p.length
    for (i in 0 until s.length - hops + 1) {
        sb.setLength(0)
        sb.append(s, i, i + hops)
        if (matches(sb, target)) anagrams.add(i)
    }
    return anagrams
}

fun matches(sb: StringBuilder, target: IntArray): Boolean {
    val value = IntArray(26)
    for (element in sb) {
        value[element - 'a']++
    }
    for (i in value.indices) {
        if (value[i] != target[i]) return false
    }
    return true
}
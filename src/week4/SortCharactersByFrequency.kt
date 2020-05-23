/**

    Given a string, sort it in decreasing order based on the frequency of characters.

    Example 1:

    Input:
    "tree"

    Output:
    "eert"

    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

    Example 2:

    Input:
    "cccaaa"

    Output:
    "cccaaa"

    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.

    Example 3:

    Input:
    "Aabb"

    Output:
    "bbAa"

    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.

 */


package week4

import java.util.*


fun main()
{
    println(frequencySort("tree"))
    println(frequencySort("cccaaa"))
    println(frequencySort("Aabb"))
}

fun frequencySort(s: String?): String? {
    val res = StringBuilder()
    if (s == null || s.isEmpty()) {
        return res.toString()
    }
    val map = HashMap<Char, Int>()
    for (c in s.toCharArray()) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    val bucketList: Array<MutableList<Char>?> = arrayOfNulls<MutableList<Char>?>(s.length + 1)
    for (key in map.keys) {
        val freq = map[key]!!
        if (bucketList[freq] == null) {
            bucketList[freq] = arrayListOf()
        }
        bucketList[freq]!!.add(key)
    }
    for (i in bucketList.indices.reversed()) {
        if (bucketList[i] != null) {
            for (c in bucketList[i]!!) {
                for (j in 0 until i) {
                    res.append(c)
                }
            }
        }
    }
    return res.toString()
}
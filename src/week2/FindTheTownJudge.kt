/**

    In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.
    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

    Example 1:

    Input: N = 2, trust = [[1,2]]
    Output: 2

    Example 2:

    Input: N = 3, trust = [[1,3],[2,3]]
    Output: 3

    Example 3:

    Input: N = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1

    Example 4:

    Input: N = 3, trust = [[1,2],[2,3]]
    Output: -1

    Example 5:

    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    Output: 3


    Note:

    1 <= N <= 1000
    trust.length <= 10000
    trust[i] are all different
    trust[i][0] != trust[i][1]
    1 <= trust[i][0], trust[i][1] <= N

 */


package week2

import java.util.*


fun main()
{
    val arr1 = intArrayOf(1,3)
    val arr2 = intArrayOf(1,4)
    val arr3 = intArrayOf(2,3)
    val arr4 = intArrayOf(2,4)
    val arr5 = intArrayOf(4,3)
    val inputArray = arrayOf(arr1, arr2, arr3, arr4, arr5)
    println(findJudge(4, inputArray))
}

fun findJudge(N: Int, trust: Array<IntArray>): Int {
    if (trust.isEmpty()) return 1
    val parents = IntArray(N + 1)
    for (i in 1 until N + 1) {
        parents[i] = i
    }
    val map = HashMap<Int, MutableList<Int>>()
    for (data in trust) {
        val a = data[0]
        val b = data[1]
        parents[a] = b
        map.computeIfAbsent(b)
        { ArrayList() }.add(a)
    }
    val it: Iterator<*> = map.entries.iterator()
    while (it.hasNext()) {
        val e = it.next() as Map.Entry<*, *>
        val members = e.value as ArrayList<*>
        if (members.size == N - 1) {
            val key = e.key as Int
            return if (parents[key] != key) -1 else e.key as Int
        }
    }
    return -1
}
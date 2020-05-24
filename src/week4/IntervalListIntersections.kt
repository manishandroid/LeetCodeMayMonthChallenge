/**

    Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

    Return the intersection of these two interval lists.

    (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

    Example 1:

    Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.

 */


package week4

import kotlin.math.max
import kotlin.math.min


fun main()
{
    val list1 = arrayOf(intArrayOf(0,2), intArrayOf(5,10), intArrayOf(13,23), intArrayOf(24,25))
    val list2 = arrayOf(intArrayOf(1,5), intArrayOf(8,12), intArrayOf(15,24), intArrayOf(25,26))

    val result = intervalIntersection(list1, list2)

    for (i in result!!)
        print(i.contentToString())
}

fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray>? {
    var i = 0
    var j = 0
    val list: MutableList<IntArray> = ArrayList()
    while (i < A.size && j < B.size) {
        val start = max(A[i][0], B[j][0])
        val end = min(A[i][1], B[j][1])
        if (start <= end) {
            list.add(intArrayOf(start, end))
        }
        if (end == A[i][1]) {
            i++
        } else {
            j++
        }
    }
    val result = Array(list.size) { IntArray(2) }
    for (k in list.indices) {
        result[k] = list[k]
    }
    return result
}
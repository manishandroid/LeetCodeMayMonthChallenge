/**

    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:

    Input: [3,2,3]
    Output: 3

    Example 2:

    Input: [2,2,1,1,1,2,2]
    Output: 2


 */


package week1

import java.util.*


fun main()
{
    val arr1 = intArrayOf(3,2,3)
    println(majorityElement(arr1))

    val arr2 = intArrayOf(2,2,1,1,1,2,2)
    println(majorityElement(arr2))
}

fun majorityElement(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    val map = HashMap<Int, Int?>()
    for (i in nums.indices) {
        if (map.containsKey(nums[i])) {
            val count = map[nums[i]]!! + 1
            if (count > nums.size / 2) {
                return nums[i]
            } else map[nums[i]] = count
        } else map[nums[i]] = 1
    }
    return 1
}
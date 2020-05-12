/**

    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



    Example 1:

    Input: [1,1,2,3,3,4,4,8,8]
    Output: 2
    Example 2:

    Input: [3,3,7,7,10,11,11]
    Output: 10

 */


package week2

fun main()
{
     val inputArray = intArrayOf(3,3,7,7,10,11,11)
    println(singleNonDuplicate(inputArray))
}

fun singleNonDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if ((mid - left) % 2 == 1) {
            if (nums[mid] == nums[mid - 1]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        } else {
            if (nums[mid] == nums[mid - 1]) {
                right = mid - 2
            } else {
                left = mid
            }
        }
    }
    return nums[left]
}
/**

    Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Note:
    You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true

 */


package week1

import java.util.*


fun main()
{
    println(canConstruct("aa", "aab"))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val freq: MutableMap<Char, Int?> = HashMap()
    for (c in magazine.toCharArray()) {
        if (freq.containsKey(c)) {
            freq[c] = freq[c]!! + 1
        } else {
            freq[c] = 1
        }
    }
    for (c in ransomNote.toCharArray()) {
        if (freq.containsKey(c)) {
            if (freq[c]!! > 1) {
                freq[c] = freq[c]!! - 1
            } else {
                freq.remove(c)
            }
        } else {
            return false
        }
    }
    return true
}
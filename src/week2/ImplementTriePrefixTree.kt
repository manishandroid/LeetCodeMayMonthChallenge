/**

    Implement a trie with insert, search, and startsWith methods.

    Example:

    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");
    trie.search("app");     // returns true

    Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.

 */


package week2

fun main()
{
    val trie = Trie()

    trie.insert("apple")
    println(trie.search("apple")) // returns true
    println(trie.search("app")) // returns false
    println(trie.startsWith("app")) // returns true

    trie.insert("app")
    println(trie.search("app")) // returns true
}

internal class Trie {

    internal inner class TrieNode {
        var isEnd = false
        var next: Array<TrieNode?> = arrayOfNulls(26)

    }

    private val root: TrieNode

    /** Inserts a word into the trie.  */
    fun insert(word: String?) {
        if (word != null) {
            val len = word.length
            var ch: Char
            var current: TrieNode? = this.root
            var i = 0
            while (i < len) {
                ch = word[i]
                if (current!!.next[ch - 'a'] == null) {
                    current.next[ch - 'a'] = TrieNode()
                }
                current = current.next[ch - 'a']
                i++
            }
            current!!.isEnd = true
        }
    }

    /** Returns if the word is in the trie.  */
    fun search(word: String?): Boolean {
        return if (word == null || word.isEmpty()) {
            true
        } else {
            val len = word.length
            var ch: Char
            var current: TrieNode? = root
            var i = 0
            while (i < len) {
                ch = word[i]
                if (current!!.next[ch - 'a'] == null) {
                    return false
                }
                current = current.next[ch - 'a']
                i++
            }
            current!!.isEnd
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix.  */
    fun startsWith(prefix: String?): Boolean {
        return if (prefix == null || prefix.isEmpty()) {
            true
        } else {
            val len = prefix.length
            var ch: Char
            var current: TrieNode? = root
            var i = 0
            while (i < len) {
                ch = prefix[i]
                if (current!!.next[ch - 'a'] == null) {
                    return false
                }
                current = current.next[ch - 'a']
                i++
            }
            true
        }
    }

    /** Initialize your data structure here.  */
    init {
        this.root = TrieNode()
    }
}
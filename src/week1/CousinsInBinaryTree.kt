/**
    In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

    Return true if and only if the nodes corresponding to the values x and y are cousins.

    Example 1:

    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

    Example 2:

    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

    Example 3:

    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false

    Note:

    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.

    1,2,3,null,4,null,5

 */


package week1

import java.util.*


fun main()
{
    val treeNode = TreeNode(1)
    treeNode.left = TreeNode(2)
    treeNode.right = TreeNode(3)
    treeNode.left?.right = TreeNode(4)
    treeNode.right?.right = TreeNode(5)

    println(isCousins(treeNode, 4, 5))
}

fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    if (root == null || root.`val` == x || root.`val` == y) return false
    val map: MutableMap<Int, IntArray> = HashMap()
    val q: Queue<TreeNode?> = LinkedList()
    q.offer(root)
    var level = 0
    while (!q.isEmpty()) {
        var size = q.size
        while (size-- != 0) {
            val parent = q.poll()
            val `val` = parent!!.`val`
            if (parent.left != null) {
                val leftVal = parent.left!!.`val`
                map[leftVal] = IntArray(2)
                map[leftVal]!![0] = `val`
                map[leftVal]!![1] = level
                q.offer(parent.left)
            }
            if (parent.right != null) {
                val rightVal = parent.right!!.`val`
                map[rightVal] = IntArray(2)
                map[rightVal]!![0] = `val`
                map[rightVal]!![1] = level
                q.offer(parent.right)
            }
        }
        level++
    }
    val p1 = map[x]
    val p2 = map[y]
    return p1!![0] != p2!![0] && p1[1] == p2[1]
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

}
/**

    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
            3
          /   \
        1       4
         \
          2

    Output: 1

    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
            5
          /  \
        3      6
       / \
      2   4
     /
    1

    Output: 3

 */


package week3

fun main()
{
    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(1)
    treeNode.right = TreeNode(4)
    treeNode.left?.right = TreeNode(2)

    println(kthSmallest(treeNode, 1))

    val treeNode1 = TreeNode(5)
    treeNode1.left = TreeNode(3)
    treeNode1.right = TreeNode(6)
    treeNode1.left?.left = TreeNode(2)
    treeNode1.left?.right = TreeNode(4)
    treeNode1.left?.left?.left = TreeNode(1)

    println(kthSmallest(treeNode1, 3))
}

var ans = 0
var count = 0

fun kthSmallest(root: TreeNode?, k: Int): Int {
    ans = 0
    inorder(root, k)
    return ans
}

fun inorder(root: TreeNode?, k: Int) {
    if (root == null) return
    inorder(root.left, k)
    count++
    if (count == k) {
        ans = root.`val`
        return
    }
    inorder(root.right, k)
}

class TreeNode {
    var `val` = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    internal constructor() {}
    internal constructor(`val`: Int) {
        this.`val` = `val`
    }

    internal constructor(`val`: Int, left: TreeNode?, right: TreeNode?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}
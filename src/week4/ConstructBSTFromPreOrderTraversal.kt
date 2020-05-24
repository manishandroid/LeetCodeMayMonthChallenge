/**

    Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
    It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

    Example 1:
    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

            8
          /   \
         5      10
       /   \      \
      1     7      12

    Constraints:
    1 <= preorder.length <= 100
    1 <= preorder[i] <= 10^8
    The values of preorder are distinct.

 */


package week4

fun main()
{
    val arr = intArrayOf(8,5,1,7,10,12)
    val treeNode = bstFromPreOrder(arr)
    val resultArr = arrayListOf<Int?>()
    resultArr.add(treeNode?.`val`)
    resultArr.add(treeNode?.left?.`val`)
    resultArr.add(treeNode?.right?.`val`)
    resultArr.add(treeNode?.left?.left?.`val`)
    resultArr.add(treeNode?.left?.right?.`val`)
    resultArr.add(treeNode?.right?.left?.`val`)
    resultArr.add(treeNode?.right?.right?.`val`)
    println(resultArr.toArray().contentToString())
}

var i = 0

fun bstFromPreOrder(preOrder: IntArray): TreeNode? {
    return bstFromPreOrder(preOrder, Int.MAX_VALUE)
}

fun bstFromPreOrder(preOrder: IntArray, bound: Int): TreeNode? {
    if (i == preOrder.size || preOrder[i] > bound) {
        return null
    }
    val root = TreeNode(preOrder[i++])
    root.left = bstFromPreOrder(preOrder, root.`val`)
    root.right = bstFromPreOrder(preOrder, bound)
    return root
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
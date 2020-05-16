/**

    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

    Example 1:

    Input: 1->2->3->4->5->NULL
    Output: 1->3->5->2->4->NULL

    Example 2:

    Input: 2->1->3->5->6->4->7->NULL
    Output: 2->3->6->7->1->5->4->NULL

    Note:

    The relative order inside both the even and odd groups should remain as it was in the input.
    The first node is considered odd, the second node even and so on ...

 */


package week3

fun main()
{
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(3)
    listNode.next?.next?.next = ListNode(4)
    listNode.next?.next?.next?.next = ListNode(5)
    listNode.next?.next?.next?.next?.next = ListNode()

    val resultListNode = oddEvenList(listNode)
    println(resultListNode.`val`)
    println(resultListNode.next?.`val`)
    println(resultListNode.next?.next?.`val`)
    println(resultListNode.next?.next?.next?.`val`)
    println(resultListNode.next?.next?.next?.next?.`val`)
    println(resultListNode.next?.next?.next?.next?.next?.`val`)

}

fun oddEvenList(head: ListNode): ListNode {
    var p1: ListNode = head
    var p2: ListNode = head.next!!
    val pre: ListNode = p2
    while (p2.next != null) {
        p1.next = p2.next
        p1 = p1.next!!
        p2.next = p1.next
        p2 = p2.next!!
    }
    p1.next = pre
    return head
}

class ListNode {
    var `val` = 0
    var next: ListNode? = null

    internal constructor() {}
    internal constructor(`val`: Int) {
        this.`val` = `val`
    }

    internal constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
}
/*

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []

 

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

*/

// Iterative Solution
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        // Create reversed list head
        ListNode reversedHead = null;
        
        while (head != null) {

            // Temporarily store unreversed list next
            ListNode tempUnreversedNext = head.next;

            // Point head to previous node in unreversed list
            head.next = reversedHead;

            // Shift reversed list head and head through unreversed list
            reversedHead = head;
            head = tempUnreversedNext;

        }

        return reversedHead;
    }
}
*/

// Recursive Solution

class Solution {
    public ListNode reverseList(ListNode head) {
        
        // Check base case where list is 0 or 1 nodes
        if (head == null || head.next == null){
            return head;
        }

        // Recurse to end of call stack
        ListNode new_head = reverseList(head.next);

        // Reverse pointers
        head.next.next = head;
        head.next = null;
        
        // Return reversed head
        return new_head;
    }
}

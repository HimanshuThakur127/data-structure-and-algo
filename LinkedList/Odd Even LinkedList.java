/*
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head.next == null || head.next.next == null) return head;
        ListNode odd_st = head;
        ListNode odd_end = head;
        ListNode even_st = head.next;
        ListNode even_end = head.next;
        ListNode curr = head.next.next;
        int count = 1;
        while(curr != null){
            if(count % 2 == 0){
              even_end.next = curr;
              even_end = curr;
            }
            else{
              odd_end.next = curr;
              odd_end = curr;
            }
            count+=1;
            curr = curr.next;
        }
       
        odd_end.next = even_st;
        even_end.next = null;
        return odd_st;
    }
}
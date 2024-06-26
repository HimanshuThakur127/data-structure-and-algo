/*
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
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
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<Integer>();
        ListNode curr = head;
        while(curr != null){
            st.push(curr.val);
            curr = curr.next;
        }
        int max = Integer.MIN_VALUE;
        curr = head;
        int half = st.size()/2;
        while(curr != null &&  half-->0){
            max = Math.max(curr.val+st.pop(), max);
            curr = curr.next;
        }
        return max;
    }
}
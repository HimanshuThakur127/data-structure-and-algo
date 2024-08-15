/*
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
 */

 class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
        for(int elm: nums){
            pr.add(elm);
        }
        for(int i=0;i<nums.length-k;i++){
            pr.poll();
        }
        return pr.peek();
    }
}

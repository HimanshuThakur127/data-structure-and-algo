// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
          if(i == 0) left[i] = nums[i];  
          else left[i] = left[i-1]*nums[i];
        }
        for(int i = nums.length-1;i>=0;i--){
          if(i == nums.length-1) right[i] = nums[i];  
          else right[i] = right[i+1]*nums[i];
        }
        for(int i=0;i<nums.length;i++){
           int l = 1,r = 1; 
           if(i-1 >= 0) l = left[i-1];
           if(i+1 < nums.length) r = right[i+1];
           ans[i] = l*r; 
        }
        return ans;
    }
}
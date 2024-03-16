// Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

// answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
// answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
// Note that the integers in the lists may be returned in any order.

 

// Example 1:

// Input: nums1 = [1,2,3], nums2 = [2,4,6]
// Output: [[1,3],[4,6]]
// Explanation:
// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
// Example 2:

// Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
// Output: [[3],[]]
// Explanation:
// For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
// Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> left = findDiffElements(nums1, nums2);
      List<Integer> right = findDiffElements(nums2, nums1);
      ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
      ans.add(left);ans.add(right);
      return ans;
    }
    private List<Integer> findDiffElements(int[] left,int[] right){
        List<Integer> ls = new ArrayList<Integer>();
        int l_st = 0, l_end = left.length, r_st = 0, r_end = right.length;
        while(l_st < l_end){
           r_st = 0; 
           while(((l_st + 1) < l_end) && left[l_st] == left[l_st+1]) l_st++;
           while(r_st < r_end && left[l_st] > right[r_st]){
             r_st++;
           }
           if(r_st == r_end || left[l_st] < right[r_st]){
             ls.add(left[l_st]);
           }
           l_st++; 
        }
        return ls;
    }  
}
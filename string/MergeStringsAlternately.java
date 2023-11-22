// https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75

// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
// Return the merged string.
// Example 1:
// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder st = new StringBuilder();
        int i = 0, j = 0;
        while(i< word1.length() && j< word2.length()){
           st.append(word1.charAt(i++));
           st.append(word2.charAt(j++));
        }
        st.append(leftOver(word1,i));
        st.append(leftOver(word2,j));
        return new String(st);
    }
    private String leftOver(String word, int idx){
        return idx < word.length() ? word.substring(idx) : ""; 
    }
}
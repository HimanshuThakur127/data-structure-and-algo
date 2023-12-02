// https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75

// For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

// Example 1:

// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Example 2:

// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"
// Example 3:

// Input: str1 = "LEET", str2 = "CODE"
// Output: ""

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String shorter = str1.length() > str2.length() ? str2 : str1;
        String longer = str1.length() > str2.length() ? str1 : str2;
        for(int j = shorter.length();j>0;j--){
            String temp = shorter.substring(0, j);
            if(ableToDivide(temp, shorter) && ableToDivide(temp, longer)) 
              return temp;
        }
        return "";
    }
    private boolean ableToDivide(String temp, String str){
       if(temp.length() == 0) return false; 
       for(int i=0;i<str.length();i+=temp.length()){
           if(!temp.equals(str.substring(i, Math.min(i+temp.length(), str.length())))){
               return false;
           }
       }
       return true;
    }
}
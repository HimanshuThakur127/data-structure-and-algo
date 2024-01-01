// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"


class Solution {
    public String reverseVowels(String s) {
        int st = 0, end = s.length()-1;
        StringBuilder res = new StringBuilder(s);
        while(st < end){
            char left_ch = s.charAt(st);
            char right_ch = s.charAt(end);
            boolean left_vw = vowels(left_ch);
            boolean right_vw = vowels(right_ch);
            if(left_vw && right_vw){
               res.setCharAt(st, right_ch);
               res.setCharAt(end, left_ch);
               st++;
               end--;
            }
            else {
               if(!left_vw){
                 res.setCharAt(st, left_ch);  
                 st++;
               }
               if(!right_vw){
                 res.setCharAt(end, right_ch);  
                 end--;
               }
            }
        }
        return res.toString();
    }
    private boolean vowels(char c){
        char[] ch = {'a','e','i','o','u','A','E', 'I', 'O', 'U'};
        for(char i: ch){
           if(i == c) return true; 
        }
        return false;
    }
}
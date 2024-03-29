// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

// Example 1:

// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.
// Example 2:

// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.
// Example 3:

// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.

class Solution {
    public int maxVowels(String s, int k) {
        int i = 0, currVowels = 0, maxVowels = 0;
        for(int j = 0;j<s.length();j++){
            char c = s.charAt(j);
            if(vowelsCheck(c)){
               currVowels+=1;
            }
            if(k == j-i+1){
               if(currVowels > maxVowels) maxVowels = currVowels;
               if(vowelsCheck(s.charAt(i))) currVowels-=1;
               i++;
            }
            if(s.length()-i<k){
                break;
            }
        }
        return maxVowels;
    }
    private boolean vowelsCheck(char c){
       return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
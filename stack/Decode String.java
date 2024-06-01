// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

// The test cases are generated so that the length of the output will never exceed 105.

 

// Example 1:

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:

// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:

// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"

class Solution {
    public String decodeString(String s) {
      Stack<String> st = new Stack<String>();
      StringBuilder str;
      String[] stArray = s.split("");
      int index = 0;
      while(index < stArray.length){
        String c = stArray[index];
        if(!c.equals("]")){
           String s_dig = "";
           //System.out.println(isNumber(c)+":"+c);
           while(isNumber(stArray[index])){
            s_dig = s_dig + stArray[index];
            index++;
           }
           if(s_dig.length() == 0) {
            s_dig = c;
           } 
           else index--;
           st.push(s_dig);        
        }
        else{
          //System.out.println(c+" else part");  
          str = new StringBuilder();  
          while(!st.isEmpty()){
            if(st.peek().equals("[")){
                st.pop();
                int rep = 1;
                if(!st.isEmpty() && isNumber(st.peek())){
                    rep = Integer.parseInt(st.pop());
                }
                String s_rep = str.toString().repeat(rep);
                //System.out.println(s_rep);
                st.push(s_rep);
                break;  
            }
            else{
                str.insert(0,st.pop());
            }
          }
        }
        index++;
        //System.out.println(st);
      }
      str = new StringBuilder();
      Iterator it = st.iterator();
      while(it.hasNext()){
        str.append(it.next());
      }
      return str.toString();  
    }
    private boolean isNumber(String s) {
       if(s == null ) return false;
       for(char c: s.toCharArray()){
          if(c < '0' || c > '9') return false;
       }
       return true;
    }
}
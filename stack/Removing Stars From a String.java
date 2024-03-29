class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '*'){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        Iterator it = st.iterator();
        StringBuilder str = new StringBuilder();
        while(it.hasNext()) str.append(it.next());
        return str.toString();
    }
}
// We are given an array asteroids of integers representing asteroids in a row.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

// Example 1:

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:

// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
// Example 3:

// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();
        for(int ast: asteroids){
            if(st.isEmpty()){
                st.push(ast);
                continue;
            }
            else{
                boolean flag = false;
                if((st.peek() > 0 && ast > 0) || (st.peek() < 0 && ast < 0) || (st.peek() < 0 && ast > 0 )) st.push(ast);
                while((st.size() != 0) && (st.peek() > 0 && ast < 0)){
                    if(Math.abs(st.peek()) > Math.abs(ast)){
                        flag = false;
                        break;
                    }
                    else if((ast+st.peek()) == 0){
                        flag = false;
                        st.pop();
                        break;
                    }
                    else{
                        st.pop();
                        flag = true;
                    }  
                }
                if(flag) st.push(ast);
            }
        }
        //System.out.println("st="+st);
        int[] res = new int[st.size()];
        int i = st.size() - 1;
        while (st.size() != 0) {
            res[i] = st.pop();
            i--;
        }
        return res;
    }
}
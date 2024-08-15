/*
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 */

 class Solution {
    double val;
    class Pair{
        private String v;
        private double exp;
        Pair(String v, double exp){
            this.v = v;
            this.exp = exp;
        }
        private String getVal() {
            return this.v;
        }
        private double getExp() {
            return this.exp;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> map = new HashMap<>();
        for(int i = 0;i<equations.size();i++){
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double val = values[i];

            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(new Pair(y, val));
            map.putIfAbsent(y, new ArrayList<>());
            map.get(y).add(new Pair(x, (1/val))); 
        }
        double[] ans = new double[queries.size()];
        
        for(int i=0;i<queries.size();i++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            val = -1;
            if(!map.containsKey(x)) {
              ans[i] = val;
              continue;
            };
            dfs(x, y, 1, map, new HashSet<>());
            ans[i] = val;
        }
        return ans;
    }
    private void dfs(String s, String d, double computation, Map<String, List<Pair>> map,HashSet<String> set) {
        if(s.equals(d)){
            val = computation;
            return;
        }
        set.add(s);
        for(Pair p: map.get(s)){
            if(set.contains(p.getVal())) continue;
            dfs(p.getVal(), d, computation*p.getExp(), map, set);
        }
    }
}
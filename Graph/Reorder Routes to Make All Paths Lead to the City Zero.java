/*
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 */

 class Solution {
    class Pair {
        int des;
        boolean direction;
        Pair(int d, boolean direct){
            this.des = d;
            this.direction = direct;
        }
    }
    int output = 0;
    public int minReorder(int n, int[][] connections) {
       boolean[] visited = new boolean[n];
       List<List<Pair>> adj = new ArrayList<>();
       for(int i = 0;i<n;i++){
         adj.add(new ArrayList<>());
       }
       for(int[] con: connections){
         adj.get(con[0]).add(new Pair(con[1], true));
         adj.get(con[1]).add(new Pair(con[0], false));
       }
       dfs(0, -1, adj);
       return output;
    }
    
    private void dfs(int node, int parent,List<List<Pair>> adj) {
       for(Pair p: adj.get(node)){
         int neighbour = p.des;
         boolean direction = p.direction;
         if(node != parent){
           if(direction) {
              output+=1;
              
           }
           dfs(neighbour, node,adj);
         }
       }
    }
}
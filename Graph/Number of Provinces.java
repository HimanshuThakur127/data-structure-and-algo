/*
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

 */

 class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       List<List<Integer>> adj = new ArrayList<List<Integer>>();
       boolean[] visited = new boolean[n];
       int result = 0;
       for(int i=0; i< n;i++){
        adj.add(new ArrayList<Integer>());
        visited[i] = false;
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i == j) continue;
            if(isConnected[i][j] == 1){
                adj.get(i).add(j);
            }
        }
       }
       
       for(int i=0;i<n;i++){
          if(!visited[i]){
            result+=1;
            dfs(i, adj, visited);
          }
       }
       return result;
    }
    private void dfs(int node,List<List<Integer>> ls, boolean[] visited) {
       visited[node] = true;
       for(int ad: ls.get(node)){
         if(!visited[ad]) {
            dfs(ad, ls, visited);
         }
       }
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int pair[] : prerequisites) {
            adj.get(pair[0]).add(pair[1]);
        }
        int visited[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0 && !dfs(adj, visited, i))
                return false;
        }
        return true;
    }
    
    public static boolean dfs(List<List<Integer>> adj, int[] visited, int v){
        if(visited[v] == 1) return false;
        if(visited[v] == 2) return true;  //// --- THIS CHECK ADDED
        visited[v] = 1;
        for(int ad : adj.get(v)){
            if(!dfs(adj, visited, ad)) return false;
        }
        visited[v] = 2;
        return true;
    }
}
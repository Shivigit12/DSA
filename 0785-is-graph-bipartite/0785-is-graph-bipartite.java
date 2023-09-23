class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        Arrays.fill(colour, -1);
        for(int i = 0; i < graph.length; i++) {
            if(colour[i] == -1) {
                if(bfs(i, graph, colour) == false)
                    return false;
            }
                
        }
        return true;
    }
    
    public boolean bfs(int start, int[][] graph, int[] colour) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colour[start] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i : graph[node]) {
                if(colour[i] == -1){
                    q.offer(i);
                    colour[i] = 1 - colour[node];
                }else if(colour[i] == colour[node])
                    return false;
            }
        }
        return true;
    }
}
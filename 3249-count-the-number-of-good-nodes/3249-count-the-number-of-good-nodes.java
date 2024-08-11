class Solution {
    private List<List<Integer>> adj;
    private int ans;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ans = 0;
        dfs(0, -1);
        return ans;
    }
    
    public int dfs(int node, int parent) {
        int subTreeSize = -1;
        int totalNodes = 0;
        boolean isGood = true;
        for(int n : adj.get(node)) {
            if(n == parent)
                continue;
            int currSize = dfs(n, node);
            if(subTreeSize == -1)
                subTreeSize = currSize;
            else if(currSize != subTreeSize)
                isGood = false;
            totalNodes += currSize;
        }
        if(isGood)
            ans++;
        return totalNodes + 1;
    }
}
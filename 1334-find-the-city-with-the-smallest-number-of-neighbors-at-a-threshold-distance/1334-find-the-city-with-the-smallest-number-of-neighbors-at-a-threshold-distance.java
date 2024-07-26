class Solution {
     public int findTheCity(int n, int[][] edges, int thresh) {
        // floyd warshall - O(n^3)
        int max = Integer.MAX_VALUE;
        int [][] graph = new int[n][n];
        
// initialize the graph with maximum values
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++ )
                if( i != j )
                    graph[i][j] = max;

//initialize it with the edge weights provided
        for(int e[] : edges){
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }

// printing that graph
       for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++ ){
                if (graph[i][j] == max) 
                    System.out.print("INF\t");
                else
                    System.out.print(graph[i][j] +"\t");
            }
            System.out.println();
        }            
        System.out.println();

        for(int i = 0; i < n; i ++ )
            for(int j = 0; j < n; j ++)
                for(int k = 0; k < n; k ++ )
                    if(graph[j][i] != max && graph[i][k] != max)
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);

//printing that graph
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++ ){
                if (graph[i][j] == max) 
                    System.out.print("INF\t");
                else
                    System.out.print(graph[i][j] +"\t");
            }
            System.out.println();
        }

//finding the city with minimum number of cities with paths at most = threshold value
        int node = 0;
        for(int i = 0; i < n; i ++){
            int c = 0; // counting the number of cities
            for(int j = 0; j < n; j ++ ){
                if(graph[i][j] <= thresh)
                    c ++;
            }
            if( c <= max ){
                node = i;
                max = c;
            }
        }
        return node;
    }
}
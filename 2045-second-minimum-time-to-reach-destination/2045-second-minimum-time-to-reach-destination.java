class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Initialize the graph as an adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // BFS queue: stores pairs of (node, current time)
        Deque<int[]> deque = new LinkedList<>();
        int[] visitedNum = new int[n + 1]; // Tracks how many times each node is visited
        int[] timeArr = new int[n + 1]; // Tracks the time when each node is visited
        Arrays.fill(timeArr, -1);
        deque.offerLast(new int[]{1, 0}); // Start from node 1 with time 0
        timeArr[0] = 0;

        // Perform BFS
        while (deque.size() > 0) {
            int curSize = deque.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = deque.pollFirst();

                int nextTime = 0;
                int curLight = cur[1] / change; // Determine the light state at the current time
                if (curLight % 2 == 0) {
                    // If the light is green, add travel time directly
                    nextTime = cur[1] + time;
                } else {
                    // If the light is red, wait until it turns green, then add travel time
                    nextTime = (curLight + 1) * change + time;
                }

                // Explore neighbors
                for (int nextNode : graph[cur[0]]) {
                    // Visit the node if it hasn't been visited twice and the nextTime is valid
                    if (visitedNum[nextNode] < 2 && timeArr[nextNode] < nextTime) {
                        deque.offerLast(new int[]{nextNode, nextTime});
                        visitedNum[nextNode]++;
                        timeArr[nextNode] = nextTime;
                        // If the target node is reached for the second time, return the time
                        if (nextNode == n && visitedNum[nextNode] == 2) return nextTime;
                    }
                }
            }
        }
        return -1;
    }
}
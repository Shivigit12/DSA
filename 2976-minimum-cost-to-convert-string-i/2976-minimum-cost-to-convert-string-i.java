class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] costs = new int[26][26];
        for (int i=0; i<26; i++) {
            Arrays.fill(costs[i], -1);
            costs[i][i] = 0;
        }
        for (int i=0; i<original.length; i++) {
            int x = original[i]-'a';
            int y = changed[i]-'a';
            if (costs[x][y] == -1 || cost[i] < costs[x][y]) {
                costs[x][y] = cost[i];
            }
        }
        // floyed-warshall
        for (int k=0; k<26; k++) {
            for (int i=0; i<26; i++) {
                for (int j=0; j<26; j++) {
                    if (costs[i][k] >= 0 && costs[k][j] >= 0 && (costs[i][j] == -1 || costs[i][k]+costs[k][j]<costs[i][j])) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                    }
                }
            }
        }
        // counting
        long amount = 0; // should be long!!!
        for (int i=0; i<source.length(); i++) {
            int x = costs[source.charAt(i)-'a'][target.charAt(i)-'a'];
            if (x == -1) {
                return -1;
            } else {
                amount += x;
            }
        }
        return amount;
    }
}
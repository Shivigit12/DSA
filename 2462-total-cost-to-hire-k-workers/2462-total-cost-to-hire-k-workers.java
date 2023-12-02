class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for(int i = 0; i < candidates; i++) {
            pq1.add(costs[i]);
        }
        for(int i = n - 1; i >= candidates && i >= n - candidates; i--) {
            pq2.add(costs[i]);
        }
        
        int start = candidates;
        int end = n - candidates - 1;
        while(k > 0) {
            if(!pq1.isEmpty() && !pq2.isEmpty()) {
                if(pq1.peek() <= pq2.peek()) {
                    ans = ans + pq1.peek();
                    pq1.remove();
                
                    if(start <= end) {
                        pq1.add(costs[start]);
                        start++;
                    }
                }
                else {
                    ans = ans + pq2.peek();
                    pq2.remove();
                
                    if(start <= end) {
                        pq2.add(costs[end]);
                        end--;
                    }
                }
            }
            else if(!pq1.isEmpty()) {
                ans = ans + pq1.peek();
                pq1.remove();
            } else if(!pq2.isEmpty()) {
                ans = ans + pq2.peek();
                pq2.remove();
            }
            k--;
        }
        return ans;
    }
}
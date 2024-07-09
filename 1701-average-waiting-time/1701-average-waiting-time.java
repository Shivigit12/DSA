class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currTime = 0;
        for(int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];
            if(currTime < arrival)
                currTime = arrival;
            int waitingTime = currTime - arrival + service;
            totalWaitingTime += waitingTime;
            currTime = currTime + service;
        }
        return totalWaitingTime / customers.length;
    }
}
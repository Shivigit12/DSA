class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxDiff = 0;
        int price = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < price)
                price = prices[i];
            else {
                maxDiff = Math.max(prices[i] - price, maxDiff);
            }
        }
        return maxDiff;
    }
}
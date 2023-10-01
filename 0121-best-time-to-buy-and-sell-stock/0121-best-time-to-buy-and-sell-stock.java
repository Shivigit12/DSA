class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int diff = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        st.push(prices[0]);
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < st.peek()) {
                st.pop();
                st.push(prices[i]);
            }else {
                diff = prices[i] - st.peek();
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        return maxDiff;
    }
}
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int q = 0;
        while(numBottles / numExchange != 0) {
            q = numBottles / numExchange;
            int empty = numBottles - q * numExchange;
            sum = sum + q;
            numBottles = q + empty;
        }
        return sum;
    }
}  

//  int res = numBottles;
//         int cur_empty = numBottles;

//         while (cur_empty / numExchange != 0) {
//             int full_drinked = cur_empty / numExchange;
//             int left_empty = cur_empty - full_drinked * numExchange;
//             res += full_drinked;
//             cur_empty = left_empty + full_drinked;
//         }

//         return res;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = 1000000000;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(canEatBanana(piles, mid, h))
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i;
    }
    
    public boolean canEatBanana(int[] piles, int mid, int h) {
        long hours = 0;
        for(int pile : piles) {
            int div = pile / mid;
            hours += div;
            if(pile % mid != 0)
                hours++;
        }
        return hours <= h;
    }
}
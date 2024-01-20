class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> isGreatest = new ArrayList<>();
        int maxNum = 0;
        for(int i = 0; i < candies.length; i++) {
            maxNum = Math.max(candies[i], maxNum);
        }
        
        int i = 0;
        while(i < candies.length) {
            if(candies[i] + extraCandies >= maxNum)
                isGreatest.add(true);
            else
                isGreatest.add(false);
            i++;
        }
        return isGreatest;
    }
}
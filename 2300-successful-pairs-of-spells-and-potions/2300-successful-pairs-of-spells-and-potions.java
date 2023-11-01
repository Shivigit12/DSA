class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++) {
            spells[i] = binarySearch(spells[i], potions, success);
        }
        return spells;
    }
    
    public int binarySearch(int num, int[] potions, long success) {
        int i = 0;
        int j = potions.length - 1;
        while(i < j) {
            int mid = i + (j - i) / 2;
            if((long)num * potions[mid] < success) {
                i = mid + 1;
            }else {
                j = mid;
            }
            
        }
        if(i == potions.length - 1) {
            if((long)num * potions[i] < success)
                return 0;
        }
        return potions.length - i;
           
        
    }
}
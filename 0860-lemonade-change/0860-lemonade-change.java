class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveC = 0;
        int tenC = 0;
      
        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                fiveC++;
            } else if(bills[i] == 10) {
                if(fiveC > 0) {
                    fiveC--;
                tenC++;
                } else
                    return false;
                
            } else if(bills[i] == 20) {
                if (fiveC > 0 && tenC > 0) {
                    fiveC--;
                    tenC--;
                } else if (fiveC > 2) {
                    fiveC = fiveC - 3;
                } else {
                    return false;
                }
            }
        }
       
        return true;
    }
}
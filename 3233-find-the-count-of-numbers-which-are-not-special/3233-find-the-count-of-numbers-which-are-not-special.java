class Solution {
    public int nonSpecialCount(int l, int r) {
        int st = (int) Math.sqrt(l);
        int end = (int) Math.sqrt(r);
        if(!isPerfectSquare(l))
            st++;
        int totalP = 0;
        for(int i = st; i <= end; i++) {
            if(isPrime(i))
                totalP++;
        }
        return r - l + 1 - totalP;
    }
    
    public boolean isPerfectSquare(int n) {
        if(n < 0)
            return false;
        int num = (int) Math.sqrt(n);
        return num * num == n;
    }
    
    public boolean isPrime(int num) {
        if(num == 1)
            return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
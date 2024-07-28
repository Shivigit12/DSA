class Solution {
    public int nonSpecialCount(int l, int r) {
        int st=(int)Math.sqrt(l);
        int end = (int)Math.sqrt(r);
        if(!isPerfectSquare(l)){
            st++;
        }
        int totalPrimes = 0;
        for(int i = st;i<=end;i++){
            if(isPrime(i)){
                totalPrimes++;
            }
        }
        int ans = r-l+1-totalPrimes;
        return ans;
    }
    public boolean isPerfectSquare(int n) {
        if (n < 0) {
            return false; // Negative numbers cannot be perfect squares
        }
        int sqrt = (int) Math.sqrt(n);
        return (sqrt * sqrt == n);
    }
    static boolean isPrime(int x){
        if(x == 1) return false;
        for(int i = 2 ; i * i <= x ; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
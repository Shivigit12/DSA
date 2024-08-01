class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String s : details) {
            
            int a = 10 * Integer.parseInt(String.valueOf(s.charAt(11)));
            a += Integer.parseInt(String.valueOf(s.charAt(12)));
            if(a > 60)
                ans++;
        }
        return ans;
    }
}
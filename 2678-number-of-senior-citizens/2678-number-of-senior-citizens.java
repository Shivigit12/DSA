class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String s : details) {
            char ch[] = s.toCharArray();
            int a = 10 * Integer.parseInt(String.valueOf(ch[11]));
            a += Integer.parseInt(String.valueOf(ch[12]));
            if(a > 60)
                ans++;
        }
        return ans;
    }
}
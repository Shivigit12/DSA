class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int m = s.length();
        int n = t.length();
        int ans = Integer.MAX_VALUE;
        int start = 0;
        for(char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int count = map.size();
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
            if(map.get(s.charAt(j)) == 0)
                count--;
            if(count == 0) {
                while(count == 0) {
                    if(ans > j - i + 1) {
                        ans = j - i + 1;
                        start = i;
                    }
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    if(map.get(s.charAt(i)) > 0)
                        count++;
                    i++;
                        
                }
            }
            j++;
                
        }
        if(ans != Integer.MAX_VALUE) {
            return s.substring(start, start + ans);
        } else
            return "";
    }
}
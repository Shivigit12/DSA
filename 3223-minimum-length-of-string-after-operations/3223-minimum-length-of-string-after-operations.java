class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int counter = 0;
        for(int i = 0; i < n; i++) {
            if(map.size() == 0 || !map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);
            else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                if(map.get(s.charAt(i)) == 3) {
                    map.put(s.charAt(i), 1);
                    counter++;
                }
            } 
        }
        return n - (counter * 2);
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String ch[] = s.split(" ");
        if(pattern.length() != ch.length)
            return false;
        for(int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(ch[i]))
                    return false;
            } else {
                if(map.containsValue(ch[i]))
                    return false;
                map.put(pattern.charAt(i), ch[i]);
            }
        }
        return true;
    }
}
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            if(map1.containsKey(ch))
                map1.put(ch, map1.get(ch) + 1);
            else
                map1.put(ch, 1);
        }
        for(int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            if(map2.containsKey(ch))
                map2.put(ch, map2.get(ch) + 1);
            else
                map2.put(ch, 1);
        }
        
        for(int i = 0; i < word2.length(); i++) {
            if(!map1.containsKey(word2.charAt(i)))
                return false;
            if(!map2.containsKey(word1.charAt(i)))
                return false;
        }
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(Map.Entry<Character, Integer> m1 : map1.entrySet()) {
            list1.add(m1.getValue());
        }
        for(Map.Entry<Character, Integer> m2 : map2.entrySet()) {
            list2.add(m2.getValue());
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        if(list1.equals(list2))
            return true;
        return false;
            
    }
}
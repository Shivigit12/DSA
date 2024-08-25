class Solution {
    public String frequencySort(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.print(map+" ");
         List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list by frequency in descending order
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
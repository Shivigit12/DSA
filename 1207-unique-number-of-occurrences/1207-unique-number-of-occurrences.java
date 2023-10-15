class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            int k = m.getValue();
            if(set.contains(k))
                return false;
            else
                set.add(k);
        }
        return true;
    }
}
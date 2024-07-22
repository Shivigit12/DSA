class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
       HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < names.length; i++){
            map.put(heights[i], names[i]);
        }
        int index = 0;
        Arrays.sort(heights);
        for(int i = heights.length - 1; i>= 0; i--){
            names[index++] = map.get(heights[i]);
        }
        return names;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int arr[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        int i = 0;
        while(i < k){
            int max = findMax(map);
            arr[i] = max;
            map.remove(max);
            i++;
        }
        return arr;
    }
    static int findMax(HashMap<Integer, Integer> map){
        int val = -1;
        int max = 0;
        for(Map.Entry<Integer, Integer> key : map.entrySet()){
            if(max < key.getValue()){
                val = key.getKey();
                max = key.getValue();
            }
        }
        return val;
    }
}
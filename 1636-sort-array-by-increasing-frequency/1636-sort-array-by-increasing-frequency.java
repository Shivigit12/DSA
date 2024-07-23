class Solution {
    public int[] frequencySort(int[] nums) {
        int ans[] = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
        }
        System.out.print(map + " ");
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(new int[] {entry.getKey(), entry.getValue()});
        }
        int index = 0;
        while(!minHeap.isEmpty()) {
            int[] min = minHeap.poll(); 
            while(index < nums.length && min[1] > 0) {
                nums[index++] = min[0];
                min[1]--;
            }
        }
        
        return nums;
    }
}
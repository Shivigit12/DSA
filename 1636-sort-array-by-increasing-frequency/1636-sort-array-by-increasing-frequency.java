class Solution {
    public int[] frequencySort(int[] nums) {
        int ans[] = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int index = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            pq.add(new int[] {m.getKey(), m.getValue()});
        }
        while(!pq.isEmpty()) {
            int min[] = pq.poll();
            while(index < nums.length && min[1] > 0) {
                ans[index++] = min[0];
                min[1]--;
            }
        }
        return ans;
    }
}
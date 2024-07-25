class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for(int i : nums) {
            pq.add(i);
            
        }
        while(j < nums.length) {
            nums[j++] = pq.poll();
        }
        return nums;
    }
}
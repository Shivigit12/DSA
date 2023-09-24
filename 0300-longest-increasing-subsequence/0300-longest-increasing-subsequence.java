class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer>al = new ArrayList<>();
        al.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] > al.get(al.size()-1)) 
              al.add(nums[i]);
            else{
                int j = binSearch(al, nums[i]);
                al.set(j, nums[i]);
            }
        }
        return al.size();
    }
    public int binSearch(List<Integer>al, int val){
        int lo = 0;
        int hi = al.size()-1;
        while(hi > lo){
            int mid = lo + (hi-lo)/2;
            if(al.get(mid) < val) lo = mid+1;
            else hi = mid;
        }
        return hi;
    }
}
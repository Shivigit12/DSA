class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int arr[] = new int[]{-1, -1};
        
        while(start <= end){
            int mid = (end + start) / 2;
            if(target <= nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target)
                arr[0] = mid;
        }
        
        start = 0;
        end = nums.length - 1;
        while(start <= end){
            int mid = (end + start) / 2;
            if(target >= nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target)
                arr[1] = mid;
        }
        return arr;
    }
}
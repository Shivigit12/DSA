class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length < 1 || nums2 == null)
            return;
        int i = 0;
        int j = nums1.length - 1;
        int start = 0;
        while(start <= nums2.length - 1) {
            nums1[j] = nums2[start];
            j--;
            start++;
        }
        Arrays.sort(nums1);
        
    }
}
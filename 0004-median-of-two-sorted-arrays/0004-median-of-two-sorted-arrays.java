class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int arr[] = new int[m + n];
        int i = 0;
        int k = 0;
        while(i < m) {
            arr[k] = nums1[i];
            k++;
            i++;
        }
        i = 0;
        while(i < n) {
            arr[k] = nums2[i];
            k++;
            i++;
        }
        Arrays.sort(arr);
        if(arr.length % 2 == 0){
            double r = 0;
            r = ((double)arr[arr.length / 2 ] + arr[(arr.length / 2) - 1]);
            return r = r / 2;
        }
        else
            return (double)arr[arr.length / 2];
    }
}
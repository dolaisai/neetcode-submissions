class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        int[] a = nums1; 
        int[] b = nums2;
        if(nums1.length > nums2.length){
            a = nums2; 
            b = nums1; 
        }

        int totalElements = nums1.length + nums2.length;
        int half = (totalElements + 1) / 2;

        int left = 0; 
        int right = a.length; 

        while(left <= right){
            int midA = left + (right - left) / 2; 
            int midB = half - midA;

            int aLeft = (midA > 0 ? (a[midA - 1]) : Integer.MIN_VALUE);   
            int aRight = (midA < a.length ? (a[midA]) : Integer.MAX_VALUE); 
            int bLeft = (midB > 0 ? (b[midB - 1]) : Integer.MIN_VALUE);   
            int bRight = (midB < b.length ? (b[midB]) : Integer.MAX_VALUE); 

            if(aLeft <= bRight && bLeft <= aRight){
                if(totalElements % 2 == 1){
                    return (double)Math.max(aLeft, bLeft);
                }
                else{
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            }
            else if (aLeft > bRight){
                right = midA - 1;
            }
            else{
                left = midA + 1;
            }
        }
        return res; 
    }
}

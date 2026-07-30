class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //swap the array if nums1 is larger - to ensure that binary partition is smaller and cut2 is in range
        if( m > n) {
            return findMedianSortedArrays(nums2,nums1);
        }

        int leftSize = (m + n + 1) / 2;
        int left = 0;
        int right = m;

        while (left <= right){
            int cut1 = ( left + right ) / 2;
            int cut2 = leftSize - cut1;
            int L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int R1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int R2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            if(L1 <= R2 && L2 <= R1){ //correct partition
                if((m + n) % 2 == 0){
                    return (Math.max(L1,L2) + Math.min(R1,R2)) / 2.0 ;
                }else{
                    return Math.max(L1,L2);
                }
            }else if (L1 > R2){
                right =  cut1 - 1;
            }else{
                left = cut1 + 1;
            }
        }
        return 0.0;
    }
}
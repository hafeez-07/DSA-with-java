class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }
        for (int x : mergedArray) {
            System.out.print(x + " ");
        }

        boolean isEven = (m + n) %2  == 0;
        int total = m+n;
        if (isEven) {
            int mid1 = total/2 - 1;
            int mid2 = total/2;
            return ((mergedArray[mid1] + mergedArray[mid2]) / 2.0);
        }
        return mergedArray[total / 2];
        
    }
}
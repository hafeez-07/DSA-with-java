class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;

            //if mid is peak
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid + 1]) return mid;

            //if mountain is increasing in mid
            if(arr[mid ] < arr[mid +1 ]) low = mid + 1;

            //if mountain is decreasing in mid
            if(arr[mid] > arr[mid + 1]) high = mid;
        }
        return 0;
    }
}
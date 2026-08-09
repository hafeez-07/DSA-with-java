class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;

            //if mid is peak
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid + 1]) return mid;
          
            if(arr[mid ] < arr[mid +1 ]){
                //still climbing -> peak is to te right
                low = mid + 1;
            } else{
                //descending -> peak is at mid or left
                high = mid;
            }
        }
        return low;
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;

            //if we are going uphill , mid cannot be peak , so move to right half
            if(nums[mid] < nums[mid+1]) left = mid + 1;

            //if we are going downhill , mid can be peak
            else right = mid;

        }
        return left;
    }
}
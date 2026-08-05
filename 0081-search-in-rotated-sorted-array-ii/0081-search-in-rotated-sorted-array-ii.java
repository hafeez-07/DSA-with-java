class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while ( low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return true;

            //if it is not possible to distinguish which side is sorted sue to duplicates , shrink the size
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
            }else if(nums[low] <= nums[mid]){  //left half is sorted
                //if it lies in left half
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{ //right half is sorted
                //if it lies in right half
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
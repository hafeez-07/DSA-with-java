class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[left] <= nums[mid]){  //if left half is sorted
                if(nums[left] <= target && target < nums[mid]){  //target lies in left half
                    right = mid - 1;
                }else{  //if it doesn't
                    left = mid + 1;
                }
            }else if( nums[mid] <= nums[right]){  //right half is sorted
                if(nums[mid] < target && target <= nums[right]){  //if target lies in second half
                    left = mid + 1;
                }else{ //if it doesn't
                    right = mid - 1;
                }
            }
        }
          return -1;
        
    }
}
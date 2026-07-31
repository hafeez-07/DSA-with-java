class Solution {
    public int splitArray(int[] nums, int k) {
        
        //find low - max of nums
        int max = nums[0];
        int totalSum = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            max = Math.max(max,nums[i]);
            totalSum+=nums[i];
        }

        int low = max;
        int high = totalSum;

        while (low <= high){
            int mid = low + ( high - low) / 2;

            //if we can split - there can be possible minimum answer
            if(canSplit(nums,mid,k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return low;
    }

    public boolean canSplit(int[] nums , int mid ,int k){
        int currSum = 0;
        int splitCount = 1;
        for(int x : nums){

            //greedy search - how many minimum split should be done 
            if(currSum + x > mid){
                splitCount++;
                currSum = x;
            }else{
                currSum +=x ;
            }

            //when mid value is too small , we will get more than k splits
            if(splitCount > k){
                return false;
            }
          
        }
        return splitCount <= k; //splitcount gives min number of subarrays required
        //if it is less than k , we can split further to make ==k
        //if u have [10,7] , we can do ->  [10] , [7]
    }
}
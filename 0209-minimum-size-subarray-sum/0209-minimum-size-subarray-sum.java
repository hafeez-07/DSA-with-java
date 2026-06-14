class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int windowSum=0;
        int minWindow = Integer.MAX_VALUE;

        for(int right=0;right<nums.length;right++){
            //minimum possible subArray
            if(minWindow==1){
                return 1;
            }
            windowSum+=nums[right];
            while(windowSum>=target){
                minWindow=Math.min(minWindow,right-left+1);
                windowSum-=nums[left++];
            }
        }
        
        return minWindow==Integer.MAX_VALUE ? 0 : minWindow;
    }
}
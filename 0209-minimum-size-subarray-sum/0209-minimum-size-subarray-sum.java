class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int windowSum=nums[0];
        if(windowSum>=target){
            return 1;
        }
        int minWindow = Integer.MAX_VALUE;
        for(int right=1;right<nums.length;right++){
            windowSum+=nums[right];
            while(windowSum>=target){
                minWindow=Math.min(minWindow,right-left+1);
                windowSum-=nums[left++];
            }
        }
        if(minWindow==Integer.MAX_VALUE){
            return 0;
        }
        return minWindow;
    }
}
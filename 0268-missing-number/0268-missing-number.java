class Solution {
    public int missingNumber(int[] nums) {
        // int missing =0;
        // for(int i=1; i<=nums.length; i++){
        //     missing ^= i;
        // }
        // for(int i=0;i<nums.length;i++){
        //     missing ^=nums[i];
        // }
        // return missing;
        int n = nums.length;
        int sum = (n*(n+1)) / 2;
        for(int x : nums){
            sum-=x;
        }
        return sum;
    }
}
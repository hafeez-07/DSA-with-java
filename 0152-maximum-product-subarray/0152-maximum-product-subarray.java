class Solution {
    public int maxProduct(int[] nums) {

        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            int num = nums[i];

            if(num < 0){
                int temp = curMin;
                curMin = curMax;
                curMax = temp;
            }

            curMin = Math.min(num , curMin * num);
            curMax = Math.max(num , curMax * num);

            max = Math.max(max , curMax);
        }

        return max;
    }
}
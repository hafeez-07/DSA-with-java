class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum=0;
        //1.initial window
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
        }
        double maxAvg = windowSum/(double)k;

        //2.slide window
        for(int i=k;i<nums.length;i++){
            windowSum+=nums[i]-nums[i-k];
            maxAvg=Math.max(maxAvg,windowSum/(double)k);
        }
        return maxAvg;

    }
}
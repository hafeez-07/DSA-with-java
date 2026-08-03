class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1; //min possible divisor
        int high = 0; //maximum possible answer is max
        for(int x : nums){
            high = Math.max(high , x);
        }

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(canDivide(nums,threshold,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
        
    }

    public boolean canDivide(int[] nums , int threshold , int mid){
        int sum = 0;
        for(int x : nums){
            sum += (x + (mid - 1)) / mid;
            if(sum > threshold) return false;
        }
        return true;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; 
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w); //bcs it must fit all pacakges
            high += w;  //upto sum value is possible
        }
            
        
        while ( low <= high){
            int mid = low + (high - low) / 2;
            if(canLoad(weights, days, mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;

    }

    public boolean canLoad(int[] weights , int days ,int mid){
        int daysNeeded = 1;
        int sum = 0;
        for(int x : weights){
            if( x + sum > mid){
                daysNeeded++;
                sum = x;
            }else sum += x;
            if(daysNeeded > days) return false; 
        }
        return true;
    }
}
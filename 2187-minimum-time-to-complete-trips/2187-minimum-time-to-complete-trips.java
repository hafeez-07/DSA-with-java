class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = Long.MAX_VALUE; //min time taken
        long high = 0; //max time needed
        for(int t : time){
            low = Math.min(low , t);
            high = Math.max(high , t);
        }
        high = (long)low * totalTrips; //fastest bus alone can complete all trips

        while ( low <= high){
            long mid = low + (high - low) / 2;
            if(canComplete(time, totalTrips , mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canComplete(int[] time , int totalTrips , long mid){
        long trips = 0;
        for(int t : time){
            trips += mid / t;
            if(trips >= totalTrips) return true;
        }
        return false;
    }
}
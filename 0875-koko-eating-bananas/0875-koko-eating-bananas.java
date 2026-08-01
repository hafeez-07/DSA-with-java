class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i=1 ; i<piles.length ; i++){
            max = Math.max(max,piles[i]);
        }

        int low = 1;  //lowest possible speed is 1
        int high = max;  //highest speed is 11 - more than this is just waste since she cannot eat from multiple piles at once

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(canFinish(piles,mid,h)){ //if she can finish in mid time , there are small possible k
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;  // we need min time

    }

    public boolean canFinish ( int[] piles , int mid , int h){
        int hoursNeeded = 0;
        for(int x : piles){
            hoursNeeded += (x + (mid - 1)) / mid; // or Math.ceil()
            if(hoursNeeded > h){
                return false;
            }
        }
        return h >= hoursNeeded; // returns possible or no
    }
}
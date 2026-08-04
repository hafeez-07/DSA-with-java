class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1; //we don't have enough flower
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int x : bloomDay){
            low = Math.min(x, low); //min day to bloom a flower
            high = Math.max(x , high);  //maximum day to bloom a flower
        }
        while(low <=high){
            int mid = low + (high - low) / 2;
            if(canMakeBouquet(bloomDay,m,k,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canMakeBouquet(int[] bloomDay, int m , int k , int mid){
        int bouquets = 0;
        int flowers = 0;
        for(int x : bloomDay){
            if(x <= mid){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers= 0;
                }
            }else flowers = 0;
            if(bouquets >= m) return true;
        }
        return false;
    }
}
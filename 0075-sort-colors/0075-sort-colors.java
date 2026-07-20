class Solution {
    public void sortColors(int[] nums) {
        int red = 0;  //represents 0
        int white = 0;   //represents 1
        int blue =0;  //represents 2

        for(int x : nums){
            if(x == 0) red++;
            if(x == 1) white++;
            if(x == 2) blue++;
        }

    for(int i=0 ; i<red;i++) nums[i]=0;
    for(int i=red; i<red+white; i++) nums[i] = 1;
    for(int i =red+white; i<nums.length; i++) nums[i] = 2;
        
        
    }
}
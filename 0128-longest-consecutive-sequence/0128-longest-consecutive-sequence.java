class Solution {
    public int longestConsecutive(int[] nums) {
        if ( nums.length == 0) return 0;
        if(nums.length == 1) return 1;
          
       Arrays.sort(nums);
       
       int len = 0;
       int maxlen=0;
      for(int i= 1 ; i < nums.length ; i++){
        if(nums[i] == nums[i-1] + 1)
             len++;
        else if ( nums[i] ==  nums[i-1]){

        }else
            len=0;
        
        maxlen = Math.max(len+1 , maxlen);
      }
      
        return maxlen;
    }
}
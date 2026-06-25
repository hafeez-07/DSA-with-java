class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 ) return 0;
        if(nums.length == 1) return 1;
        //store the elements in hashset
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
  
        int len = 0;
        int maxlen = 0;

        for(int num : set){
            //check whether this is the beginning of sequence
            //if its not , skip this
            if(set.contains(num-1)){
                continue;
            }

            //if it is a beginning of sequence
            int cur = num;
            len = 1;
            while(set.contains(cur + 1)){
                cur++;
                len++;
            }
            maxlen = Math.max(len , maxlen);

        }
        return maxlen;
    }
}
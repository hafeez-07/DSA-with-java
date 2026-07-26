class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        for(int x : nums){
            //check is this one of candidate
          if(x == candidate1) count1++;
          else if (x == candidate2) count2++;
          //else check do i have an empty slot for canidates
          else if (count1 == 0){
            candidate1 = x;
            count1 = 1;
          }else if( count2 == 0){
            candidate2 = x;
            count2 = 1;
            //else compete for seats
          }else{
            count1--;
            count2--;
          }
        }

        //check whether 2 canidates are actually appear more than n/3 times
        count1 = 0;
        count2 = 0;
        for(int x : nums){
            if(x == candidate1) count1++;
            else if(x == candidate2) count2++;
        }
        if(count1 > nums.length / 3) result.add(candidate1);
        if(count2 > nums.length / 3) result.add(candidate2);

        return result;

    }
}
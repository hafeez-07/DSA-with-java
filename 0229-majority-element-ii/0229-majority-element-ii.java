class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        //count frequency
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int n = nums.length;

        //check whether any element appear more than n/3 times
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n / 3) result.add(entry.getKey());
        }

        return result;

    }
}
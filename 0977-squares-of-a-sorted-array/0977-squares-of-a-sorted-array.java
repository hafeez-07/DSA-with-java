class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] ans = new int[nums.length];
        int idx=right;
        while(left<=right){
            int leftNum=nums[left]*nums[left];
            int rightNum=nums[right]*nums[right];
            if(leftNum<rightNum){
                ans[idx--]=rightNum;
                right--;
            }else{
                ans[idx--]=leftNum;
                left++;
            }
        }
        return ans;
    }
}
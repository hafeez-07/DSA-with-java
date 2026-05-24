class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right <= nums.length - 1) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[++left] = nums[right++];
            }
        }
        return left+1;
    }
}
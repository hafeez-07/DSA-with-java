class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);

        for(int i=0; i<2*n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n] ){
                result[stack.pop()] = nums[i%n];
            }
            if(i < nums.length) stack.push(i%n);
        }



        return result;
    }
}
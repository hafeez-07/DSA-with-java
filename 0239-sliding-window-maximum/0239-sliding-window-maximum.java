class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        for(int i=0;i<n;i++){

            //slide window
            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }

            //remove small element indices , maintaining decreasing order
            while(!deque.isEmpty()&& nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }

            //add curr index
            deque.offerLast(i);

            //record results
            if(i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
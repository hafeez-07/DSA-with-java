class Solution {
    public long maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        long sum = 0;
        for(int num : nums){
            sum += num;
            
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits));
            sb.reverse();
            int reversed = Integer.parseInt(sb.toString());
            int gain = reversed - num ;
            pq.offer(gain);
        }

        while(k > 0 && !pq.isEmpty()){
            sum+= pq.poll();
            k--;
        }

        return sum;
        
    }
}
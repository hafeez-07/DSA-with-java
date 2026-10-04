class Solution {
    public int minRotations(String s) {
        
        char[] arr = s.toCharArray();
        int first =0;
        int result = 0;

        for(int i = 0 ; i < arr.length ; i++){
            int second = arr[i]- '0';
            int diff = Math.abs(first - second);
            result += Math.min(diff,10-diff);
            first = second;
        }

        return result;
    }
}
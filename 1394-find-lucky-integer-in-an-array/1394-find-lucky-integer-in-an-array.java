class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];

        //find frequency of all numbers
        for(int x : arr){
            freq[x]++;
        }

        //compare the number and its frequency from last
        //why last ? - because we need largest lucky number
        for(int i = freq.length - 1 ; i >= 1 ; i--){
            if(i == freq[i]){
                return i;
            }
        }

        return -1;
    }
}
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] rows : grid){
            for(int value : rows){
                if(value < 0) count++;
            }
        }
        return count;
    }
}
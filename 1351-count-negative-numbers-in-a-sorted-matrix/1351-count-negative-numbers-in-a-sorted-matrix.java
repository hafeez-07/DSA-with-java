class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        //perform stair case search - use top right
        int row = 0;
        int col = cols-1;

        while(col >= 0 && row < rows){
            int element =  grid[row][col];
            if(element < 0){
                count += rows - row;
                col--;
            }else{
                row++;
            }
        }

        return count;
    }
}
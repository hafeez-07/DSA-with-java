class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //use staicase approach - start from top right
        int row = 0;
        int col = cols - 1;

        while ( row < rows && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if (target < matrix[row][col]){
                col--; //because everything left is smaller
            }else{
                row++; // because evrything below is larger
            }
        }
        return false;
    }
}
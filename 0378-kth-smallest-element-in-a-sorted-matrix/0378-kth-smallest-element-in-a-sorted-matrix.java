class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rows-1][cols-1];

        while(low < high){
            int mid = low + (high - low) / 2;
            if(countSmallerOrEqual(matrix,mid) < k){
                low = mid + 1;
            }else{
                high = mid ;
            }
        }
        return low;
    }
   
   public int countSmallerOrEqual(int[][]matrix , int target){
    int rows = matrix.length;
    int cols = matrix[0].length;
    int row = 0;
    int col = cols-1;
    int count = 0;

    while(row < rows && col >=0){
        if(matrix[row][col] <= target){
            count += col + 1; //all elements upto this column is smaller or equal
            row++;
        }else{
            col--;
        }
    }
    return count;
   }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //if the target is out of boundary
        if(target < matrix[0][0] || target > matrix[rows-1][cols-1]){
            return false;
        }

        for(int[] row : matrix){
                if(targetFound(row,target)){
                    return true;
                }
        }
        return false;
    }

    public boolean targetFound (int []arr , int target){
        int low =0;
        int high = arr.length - 1;
        while(low <=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return true;
            }else if(target < arr[mid] ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];  //index 0 - row && index 1 - count of 1's
        
        for(int i = 0 ; i <mat.length ; i++){
            int count = 0;
            for(int j =0 ; j < mat[0].length ; j++){ //get the number of 1's
                if(mat[i][j] == 1) count++;
            }
            if(count > result[1]){ //if number of 1's are greater than previous rows , update result
            //if the number of 1's are same as previous rows , we wont update , bcs take previous row 
                result[0] = i;
                result[1] = count;
            }
        }

        return result;
    }
}
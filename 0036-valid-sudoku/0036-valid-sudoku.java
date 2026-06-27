class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        //compare all rows
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(!set.add(board[i][j]))   return false;
            }
            set.clear();
        }

        //similarly compare all columns
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                 if(board[j][i]=='.') continue;
                if(!set.add(board[j][i])) return false; 
            }
            set.clear();
        }

        //each 3*3 sub boxes must contain 1-9 without repetition
        for(int row=0; row<9; row=row+3){
            for(int col=0; col<9; col=col+3){
                for(int i=row; i<row+3; i++){
                    for(int j=col ; j<col+3; j++){
                        if(board[i][j]=='.') continue;
                        if(!set.add(board[i][j])) return false;
                    }
                }
                set.clear();
            }   
        }
       
      return true;

    }
}
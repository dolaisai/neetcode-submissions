class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean res = true; 

        //create a hashset of hashsets where both sizes are 9
        List<HashSet<Character>> sudokuCols = new ArrayList();
        List<HashSet<Character>> sudokuRows = new ArrayList();
        List<HashSet<Character>> squares = new ArrayList();

        // Populate the list with 9 empty HashSets
        for (int i = 0; i < 9; i++) {
            sudokuCols.add(new HashSet<Character>());
            sudokuRows.add(new HashSet<Character>());
            squares.add(new HashSet<Character>());
        }

        //populate columns, rows, and squares of hashsets

        //cols check
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[j][i] == '.'){
                        continue;
                    }
                if(sudokuCols.get(i).contains(board[j][i])){
                    return false;
                }
                else{
                    sudokuCols.get(i).add(board[j][i]);
                }
            }
        }
        //rows check
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                        continue;
                    }
                if(sudokuRows.get(i).contains(board[i][j])){
                    return false; 
                }
                else{
                    sudokuRows.get(i).add(board[i][j]);
                }
            } 
        }

        //squares check
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[j][i] == '.'){
                        continue;
                    }
                if(squares.get(returnSquareIndex(i,j)).contains(board[j][i])){
                    return false;
                }
                else{
                    squares.get(returnSquareIndex(i,j)).add(board[j][i]);
                }
            }
        }
    
        return res;
    }

    public static int returnSquareIndex(int rowNum, int colNum){
        return (rowNum / 3) * 3 + (colNum / 3);
    }
}

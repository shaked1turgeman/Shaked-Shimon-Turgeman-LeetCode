package medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++)
                if(board[i][j]==word.charAt(0) && check(board,word,i,j,0))    return true;
        }
        return false;
    }

    public boolean check(char[][] board, String word, int i, int j, int c) {
        if(c==word.length()) return true;
        else if(i>=board.length || i<0 || j>=board[0].length || j<0)    return false;
        else if(board[i][j]!=word.charAt(c)) return false;
        else {
            char original = board[i][j];
            board[i][j] = '#';
            boolean res=(check(board,word,i+1,j,c+1)||check(board,word,i,j+1,c+1)||
            check(board,word,i-1,j,c+1)||check(board,word,i,j-1,c+1));
            board[i][j] = original;
            return res;
        }
    }
}

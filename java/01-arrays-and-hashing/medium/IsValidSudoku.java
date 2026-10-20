import java.util.HashSet;
import java.util.Set;

class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int boxSize = (int) Math.sqrt(n);

        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char value = board[i][j];
                if (value == '.') continue;
                int boxIndex = (i / boxSize) * boxSize + (j / boxSize);
                if (!rows[i].add(value) || !cols[j].add(value) || !boxes[boxIndex].add(value)) return false;                
            }
        }
        return true;
    }
}

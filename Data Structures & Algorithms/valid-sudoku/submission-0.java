class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9],
                             cols = new HashSet[9],
                             boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;

                int boardIdx = (i / 3) * 3 + (j / 3);
                char val = board[i][j];

                if (rows[i].contains(val) || cols[j].contains(val) || boxes[boardIdx].contains(val)) return false;

                rows[i].add(val);
                cols[j].add(val);
                boxes[boardIdx].add(val);

            }
        }

        return true;
    }
}

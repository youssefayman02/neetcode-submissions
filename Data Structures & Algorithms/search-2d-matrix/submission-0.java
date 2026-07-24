class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowUp = 0, rowBottom = matrix.length - 1;
        while (rowUp <= rowBottom) {
            int mid = rowUp + ((rowBottom - rowUp) / 2);
            if (target > matrix[mid][0] && target < matrix[mid][matrix[mid].length - 1]) {
                int colLeft = 0, colRight = matrix[mid].length - 1;
                while (colLeft <= colRight) {
                    int midCol = colLeft + ((colRight - colLeft) / 2);
                    if (target == matrix[mid][midCol]) {
                        return true;
                    }
                    else if (target > matrix[mid][midCol]) {
                        colLeft = midCol + 1;
                    } else {
                        colRight = midCol - 1;
                    }
                }
                return false;

            } else if (target < matrix[mid][0]) {
                rowBottom = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                rowUp = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

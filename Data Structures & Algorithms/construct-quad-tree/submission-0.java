/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length, 0, grid[0].length);
    }

    private Node helper(int[][] grid, int i, int iLimit, int j, int jLimit) {
        boolean[] check = isLeaf(grid, i, iLimit, j, jLimit);

        Node node = new Node(check[0], check[1]);
        if (check[1]) return node;

        int midRow = (i + iLimit) / 2;
        int midCol = (j + jLimit) / 2;

        node.topLeft = helper(grid, i, midRow, j, midCol);
        node.topRight = helper(grid, i, midRow, midCol, jLimit);
        node.bottomLeft = helper(grid, midRow, iLimit, j, midCol);
        node.bottomRight = helper(grid, midRow, iLimit, midCol, jLimit);

        return node;
    }

    private boolean[] isLeaf(int[][] grid, int i, int iLimit, int j, int jLimit) {
        int val = grid[i][j];

        for (int r = i; r < iLimit; r++) {
            for (int c = j; c < jLimit; c++) {
                if (grid[r][c] != val) {
                    return new boolean[]{val == 1, false};
                }
            }
        }

        return new boolean[]{val == 1, true};
    }
}
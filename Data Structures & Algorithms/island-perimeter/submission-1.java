class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return dfs(grid, visited, i, j);
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) return 1;
        if (visited[i][j]) return 0;
        if (grid[i][j] == 0) return 1;
        visited[i][j] = true;

        return dfs(grid, visited, i + 1, j) + dfs(grid, visited, i - 1, j)
                + dfs(grid, visited, i, j + 1) + dfs(grid, visited, i, j - 1);
    }
}
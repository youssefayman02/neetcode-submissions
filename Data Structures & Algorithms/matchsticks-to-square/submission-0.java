class Solution {
    private int a, b, c, d;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) return false;
        
        int target = sum / 4;
        a = target;
        b = target;
        c = target;
        d = target;

        return dfs(matchsticks, 0);
    }

    public boolean dfs(int[] matchsticks, int i) {
        if (i >= matchsticks.length) {
            return a == 0 && b == 0 && c == 0 && d == 0;
        }

        int stick = matchsticks[i];

        if (a >= stick) {
            a -= stick;
            if (dfs(matchsticks, i + 1)) return true;
            a += stick;
        }

        if (b >= stick) {
            b -= stick;
            if (dfs(matchsticks, i + 1)) return true;
            b += stick;
        }

        if (c >= stick) {
            c -= stick;
            if (dfs(matchsticks, i + 1)) return true;
            c += stick;
        }

        if (d >= stick) {
            d -= stick;
            if (dfs(matchsticks, i + 1)) return true;
            d += stick;
        }

        return false;
    }
}
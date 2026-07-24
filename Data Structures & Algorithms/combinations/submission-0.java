class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int n, int k, int currNum, List<Integer> subRes, List<List<Integer>> res) {
        if (subRes.size() == k) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        if (currNum > n) return;

        subRes.add(currNum);
        dfs(n, k, currNum + 1, subRes, res);
        subRes.remove(subRes.size() - 1);
        dfs(n, k, currNum + 1, subRes, res);
    }
}
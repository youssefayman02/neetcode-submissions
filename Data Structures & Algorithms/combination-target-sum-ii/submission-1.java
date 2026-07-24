class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> subRes, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;

            subRes.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, subRes, res);
            subRes.remove(subRes.size() - 1);
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> currRes, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        currRes.add(nums[i]);
        dfs(nums, i + 1, currRes, res);
        currRes.remove(currRes.size() - 1);
        dfs(nums, i + 1, currRes, res);
    }
}

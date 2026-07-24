class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> subRes, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        subRes.add(nums[i]);
        backtrack(nums, i + 1, subRes, res);
        subRes.remove(subRes.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        backtrack(nums, i + 1, subRes, res);
    }
}

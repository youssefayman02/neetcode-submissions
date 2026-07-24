class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, target, 0, res, temp, 0);

        return res;
    }

    public void helper(int[] nums, int target, int index, List<List<Integer>> res, List<Integer> temp, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (sum > target || index >= nums.length) {
            return;
        }

        temp.add(nums[index]);
        helper(nums, target, index, res, temp, sum + nums[index]);

        // Backtrack
        temp.remove(temp.size() - 1);

        helper(nums, target, index + 1, res, temp, sum);
    }
}

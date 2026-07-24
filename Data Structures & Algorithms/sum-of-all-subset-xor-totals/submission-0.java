class Solution {
    int res = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int i, int currRes) {
        if (i == nums.length) {
            res += currRes;
            return;
        }

        dfs(nums, i + 1, currRes);
        dfs(nums, i + 1, currRes ^ nums[i]);
    }
}
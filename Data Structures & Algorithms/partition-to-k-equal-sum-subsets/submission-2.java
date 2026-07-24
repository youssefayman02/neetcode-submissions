class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;

        int target = sum / k;

        Arrays.sort(nums);
        // reverse to descending
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // quick fail: largest number > target
        if (nums[0] > target) return false;

        int[] subsets = new int[k];
        return backtrack(nums, 0, subsets, target);
    }

    private boolean backtrack(int[] nums, int i, int[] subsets, int target) {
        if (i == nums.length) return true;

        for (int j = 0; j < subsets.length; j++) {

            // skip duplicate states
            if (j > 0 && subsets[j] == subsets[j - 1]) continue;

            if (subsets[j] + nums[i] <= target) {
                subsets[j] += nums[i];

                if (backtrack(nums, i + 1, subsets, target)) return true;

                subsets[j] -= nums[i];
            }

            // important pruning
            if (subsets[j] == 0) break;
        }

        return false;
    }

}
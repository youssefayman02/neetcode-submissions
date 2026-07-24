class Solution {
    public int removeDuplicates(int[] nums) {
        int dupPos = -1, res = 1, n = nums.length;

        if (n == 1) return res;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (dupPos == -1) dupPos = i;
            } else {
                if (dupPos != -1) {
                    nums[dupPos++] = nums[i]; 
                }
                res++;
            }
        }

        return res;
    }
}
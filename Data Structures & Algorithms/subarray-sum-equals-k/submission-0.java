class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            int diff = prefixSum - k;
            res += map.getOrDefault(diff, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return res; 
    }
}
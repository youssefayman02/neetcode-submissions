class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1, right = max;
        int ans = right;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int totalHours = 0;
            for (int pile : piles) {
                totalHours += (int) Math.ceil((double) pile / (double) mid);
            } 
            if (totalHours <= h) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

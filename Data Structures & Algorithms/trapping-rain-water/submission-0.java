class Solution {
    public int trap(int[] height) {
        int[] maxRight = new int [height.length];
        int max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[0];
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.max(Math.min(max, maxRight[i]) - height[i], 0);
            max = Math.max(max, height[i]);
        }
        return res;
    }
}

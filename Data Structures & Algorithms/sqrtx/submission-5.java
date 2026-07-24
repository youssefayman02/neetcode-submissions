class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long target = (long) mid * mid;

            if (mid * mid == x) return mid;
            if (target > x) r = mid - 1;
            else {
                l = mid + 1;
                res = mid;
            }
        }

        return res;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] current = intervals[0];
        int res = 0, n = intervals.length;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= current[0] && intervals[i][0] < current[1]) {
                res++;
                if (intervals[i][1] <= current[1]) current = intervals[i];
            } else {
                current = intervals[i];
            }
        }

        return res;
    }
}

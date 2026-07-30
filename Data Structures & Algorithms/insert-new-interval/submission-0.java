class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newInterval[1] < interval[0]) {
                res.add(newInterval);

                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }

                return res.toArray(new int[res.size()][]);
            } else if (newInterval[0] > interval[1]) {
                res.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    
}

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> sortedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            sortedIntervals.add(interval);
        }

        sortedIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] firstInterval = sortedIntervals.get(0);
        int min = firstInterval[0], max = firstInterval[1];

        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < sortedIntervals.size(); i++) {
            int[] currInterval = sortedIntervals.get(i);

            if (currInterval[0] >= min && currInterval[0] <= max) {
                min = Math.min(min, currInterval[0]);
                max = Math.max(max, currInterval[1]);
            } else {
                res.add(new int[]{min, max});
                min = currInterval[0];
                max = currInterval[1];
            }
        }

        res.add(new int[]{min, max});

        return res.toArray(new int[0][]);
    }
}

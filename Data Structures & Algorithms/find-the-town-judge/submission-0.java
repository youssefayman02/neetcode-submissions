class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        int target = n - 1;

        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][0] - 1]--; 
            arr[trust[i][1] - 1]++; 
        }

        int res = 0, label = -1, i = 1;
        for (int num : arr) {
            if (num == target) {
                label = i;
                res++;
            }
            i++;
        }

        return res != 1 ? -1 : label;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>();
         if (arr.length == k) {
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }

        int minDiff = Integer.MAX_VALUE;
        int l = 0;
        for (int r = k; r <= arr.length; r++) {
            int diff = 0;
            List<Integer> curr = new ArrayList<>();
            for (int i = l; i < r; i++) {
                diff += Math.abs(arr[i] - x);
                curr.add(arr[i]);
            }
            if (diff < minDiff) {
                minDiff = diff;
                res = curr;
            }

            l++;
        }

        return res;
    }
}
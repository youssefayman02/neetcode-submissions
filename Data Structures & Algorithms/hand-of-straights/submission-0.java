class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        for (int num : hand) {
            if (freq.get(num) == 0) continue;

            for (int x = num; x < num + groupSize; x++) {
                if (!freq.containsKey(x)) return false;
                int currFreq = freq.get(x);
                if (currFreq == 0) return false;
                freq.put(x, currFreq - 1);
            }
        }

        return true;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] pair : pairs) {
            int pos = pair[0];
            int spd = pair[1];
            double time = (double) (target - pos) / spd;
            if (stack.isEmpty() || time > stack.peek()) stack.push(time);
        }
        return stack.size();
    }
}

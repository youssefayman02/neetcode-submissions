class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;

        if (n == 1) return stones[n - 1];

        for (int stone : stones) maxHeap.add(stone);

        while (n > 1) {
            int y = maxHeap.poll(), x = maxHeap.poll();

            if (y > x) {
                maxHeap.add(y - x);
                n--;
            } else {
                n -= 2;
            }
        }

        return maxHeap.size() >= 1 ? maxHeap.peek() : 0; 
    }
}

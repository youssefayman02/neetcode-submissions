class Task {
    int count;
    int availableTime;

    Task(int count, int availableTime) {
        this.count = count;
        this.availableTime = availableTime;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) count[task - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : count) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        Queue<Task> cooldown = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            if (!cooldown.isEmpty() && cooldown.peek().availableTime == time) {
                Task task = cooldown.poll();
                maxHeap.offer(task.count);
            }

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll();
                remaining--;
                if (remaining > 0) {

                    cooldown.offer(
                        new Task(remaining, time + n + 1)
                    );

                }
            } else {
                time = cooldown.peek().availableTime - 1;
            }

            time++;

        }

        return time;

    }
}

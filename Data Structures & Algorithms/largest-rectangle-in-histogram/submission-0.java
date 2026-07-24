class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!s1.isEmpty() && s1.peek() > heights[i]) {
                int currHeight = s1.pop();
                int currIdx = s2.pop();
                maxArea = Math.max(maxArea, currHeight * (i - currIdx));
                start = currIdx;
            }
            s1.push(heights[i]);
            s2.push(start);
        }
        while (!s1.isEmpty()) {
            maxArea = Math.max(maxArea, s1.pop() * (heights.length - s2.pop()));
        }
        return maxArea;
    }
}

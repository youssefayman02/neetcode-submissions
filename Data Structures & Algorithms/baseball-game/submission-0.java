class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String s : operations) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("+")) {
                int num1 = stack.pop();
                int res = num1 + stack.peek();
                stack.push(num1);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();

        return res;
    }
}
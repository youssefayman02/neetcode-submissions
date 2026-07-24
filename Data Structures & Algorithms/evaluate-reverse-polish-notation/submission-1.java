class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                s.push(Integer.parseInt(token));
            } else {
                int firstOp = s.pop();
                int secondOp = s.pop();
                int result;
                if (token.equals("+")) result = secondOp + firstOp;
                else if (token.equals("-")) result = secondOp - firstOp;
                else if (token.equals("*")) result = secondOp * firstOp;
                else result = secondOp / firstOp;
                s.push(result);
            }
        }
        return s.pop();
    }
}

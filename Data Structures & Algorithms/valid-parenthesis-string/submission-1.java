class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>(), asterisk = new Stack();

        int i = 0;
        for (Character c : s.toCharArray()) {
            if (c == '*') {
                asterisk.push(i);
            } else if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) stack.pop();
                else if (!asterisk.isEmpty()) asterisk.pop();
                else return false;
            }
            i++;
        }

        while (!stack.isEmpty()) {
            if (asterisk.isEmpty()) return false;

            if (asterisk.peek() < stack.peek()) return false;

            stack.pop();
            asterisk.pop();
        }

        return true;
    }
}

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
           if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                
                StringBuilder encoded = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    encoded.insert(0, stack.pop());
                }
                
                stack.pop();
                
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    number.insert(0, stack.pop());
                }

                int count = Integer.parseInt(number.toString());

                StringBuilder decoded = new StringBuilder();
                while (count-- > 0) {
                    decoded.append(encoded);
                }

                stack.push(decoded.toString());
            }
        }

        StringBuilder res = new StringBuilder();
        for (String s1 : stack) {
            res.append(s1);
        }

        return res.toString();
    }
}
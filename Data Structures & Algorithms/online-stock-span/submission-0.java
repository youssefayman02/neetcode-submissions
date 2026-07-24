class StockSpanner {
    Stack<Integer> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty() && stack.peek() <= price) {
            temp.push(stack.pop());
            res++;
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        stack.push(price);

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
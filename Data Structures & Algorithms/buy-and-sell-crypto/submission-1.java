class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0, sell = 1;
        while (sell < prices.length) {
            if (prices[sell] <= prices[buy]) {
                buy = sell;
                sell++;
            } else {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
                sell++;
            }
        }
        return maxProfit;
    }
}

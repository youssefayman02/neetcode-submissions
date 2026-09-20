class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumOfGas = 0, sumOfCosts = 0, total = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            sumOfGas += gas[i];
            sumOfCosts += cost[i];
            
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        if (sumOfCosts > sumOfGas) return -1;

        return res;
    }
}

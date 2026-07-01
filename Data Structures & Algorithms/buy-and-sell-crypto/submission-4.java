class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; 
        if(prices.length == 1){
            return 0; 
        }
        int buy = 0;
        int sell = 1; 
        while(sell < prices.length){
            if(prices[buy] >= prices[sell]){
                buy = sell; 
            }
            else {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
            sell++;
        }
        return maxProfit;
    }
}

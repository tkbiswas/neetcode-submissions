class Solution {
    public int maxProfit(int[] prices) {
        int i =0; 
        int j = 1;
        int result = 0;


        while(j < prices.length){
            int profit = prices[j] - prices[i];
            result = profit > result? profit: result;
            if(prices[j] < prices[i]) {
                i =j;
                j = i +1;
            }
            else j++;

        }
        return result;
    }
}

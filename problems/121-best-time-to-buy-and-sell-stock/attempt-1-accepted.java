class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];  // Lowest price seen so far
        int maxProfit = 0;         // Best profit seen so far

        // Start from second day (index 1)
        for (int i = 1; i < prices.length; i++) {
            // If today's price is lower, update minPrice (buy here)
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Otherwise, check profit if sold today
            else {
                int todayProfit = prices[i] - minPrice;
                if (todayProfit > maxProfit) {
                    maxProfit = todayProfit;
                }
            }
        }

        return maxProfit;
    }
}
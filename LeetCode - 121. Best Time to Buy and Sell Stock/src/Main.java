public class Main {
    public static int maxProfit(int[] prices) {
        int maxPrice = prices[prices.length - 1];
        int maxProfit = 0;
        int currentPrice;
        int currentProfit;
        for (int i = prices.length - 1; 0 <= i; i--) {
            currentPrice = prices[i];
            currentProfit = maxPrice - currentPrice;
            if (currentProfit > maxProfit)
                maxProfit = currentProfit;
            if (currentPrice > maxPrice)
                maxPrice = currentPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int output = maxProfit(prices);
        System.out.println(output);
    }
}
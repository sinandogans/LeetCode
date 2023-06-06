public class Main {
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int sellPrice = prices[prices.length - 1];
        int currentPrice;
        for (int i = prices.length - 1; 0 <= i; i--) {
            currentPrice = prices[i];
            if (currentPrice >= sellPrice)
                sellPrice = currentPrice;
            else {
                totalProfit += sellPrice - currentPrice;
                sellPrice = currentPrice;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int output = maxProfit(prices);
        System.out.println(output);
    }
}
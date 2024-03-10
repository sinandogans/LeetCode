public class Main {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTravelCost = 0;
        int totalTravelCostFromStartingCandidate = -1;
        int indexOfStartingCandidate = -1;
        for (int i = 0; i < gas.length; i++) {
            int currentTravelCost = gas[i] - cost[i];
            totalTravelCost += currentTravelCost;
            if (currentTravelCost >= 0) {
                if (totalTravelCostFromStartingCandidate < 0) {
                    indexOfStartingCandidate = i;
                    totalTravelCostFromStartingCandidate = 0;
                }
            }
            totalTravelCostFromStartingCandidate += currentTravelCost;
        }
        if (totalTravelCost >= 0)
            return indexOfStartingCandidate;
        else return -1;
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
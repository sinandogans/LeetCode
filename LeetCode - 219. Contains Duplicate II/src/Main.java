import java.util.HashMap;
import java.util.Map;

public class Main {
    // algorithm
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> elementsAndIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elementsAndIndexes.containsKey(nums[i]) && (i - elementsAndIndexes.get(nums[i]) <= k))
                return true;
            elementsAndIndexes.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        // sample inputs
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }
}
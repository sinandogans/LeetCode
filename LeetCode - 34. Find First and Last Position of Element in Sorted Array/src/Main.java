public class Main {
    public static int binarySearch(int[] nums, int target, boolean firstOrLastAppearance) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int midIndex;
        int currentValue;
        int foundIndex = -1;
        while (rightIndex >= leftIndex) {
            midIndex = (leftIndex + rightIndex) / 2;
            currentValue = nums[midIndex];
            if (currentValue == target) {
                foundIndex = midIndex;
                // search for first appearance
                if (firstOrLastAppearance)
                    rightIndex = midIndex - 1;
                //search for last appearance
                else
                    leftIndex = midIndex + 1;
            } else if (currentValue > target)
                rightIndex = midIndex - 1;
            else
                leftIndex = midIndex + 1;
        }
        return foundIndex;
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstIndexOfTarget = binarySearch(nums, target, true);
        int lastIndexOfTarget = binarySearch(nums, target, false);
        if (firstIndexOfTarget == -1)
            return new int[]{-1, -1};
        return new int[]{firstIndexOfTarget, lastIndexOfTarget};
    }

    // another solution
//    public static int[] searchRange2(int[] nums, int target) {
//        int foundIndexOfTarget = binarySearch2(nums, target);
//        int firstIndexOfTarget;
//        int lastIndexOfTarget;
//        if (foundIndexOfTarget == -1)
//            return new int[]{-1, -1};
//        firstIndexOfTarget = foundIndexOfTarget;
//        lastIndexOfTarget = foundIndexOfTarget;
//        while (firstIndexOfTarget >= 0 && nums[firstIndexOfTarget] == target){
//            firstIndexOfTarget--;
//        }
//        firstIndexOfTarget++;
//        while (lastIndexOfTarget <= nums.length - 1 && nums[lastIndexOfTarget] == target) {
//            lastIndexOfTarget++;
//        }
//        lastIndexOfTarget--;
//
//        return new int[]{firstIndexOfTarget, lastIndexOfTarget};
//    }
//
//    public static int binarySearch2(int[] nums, int target) {
//        int leftIndex = 0;
//        int rightIndex = nums.length - 1;
//        int midIndex;
//        int currentValue;
//        while (rightIndex >= leftIndex) {
//            midIndex = (leftIndex + rightIndex) / 2;
//            currentValue = nums[midIndex];
//            if (currentValue == target)
//                return midIndex;
//            else if (currentValue > target)
//                rightIndex = midIndex - 1;
//            else
//                leftIndex = midIndex + 1;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 7, 7, 8, 8, 10};
        int target = 5;
        int[] output = searchRange(nums, target);
        System.out.println(output);
    }
}
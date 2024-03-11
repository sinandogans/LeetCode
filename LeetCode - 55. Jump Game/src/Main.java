public class Main {

    public static boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int maxIndex = nums[0];
        int lastMaxIndex;
        int candidateMaxIndex;
        int startIndex = 0;
        while (true) {
            lastMaxIndex = maxIndex;
            candidateMaxIndex = maxIndex;
            for (int i = startIndex; i < maxIndex + 1; i++) {
                if (i >= nums.length - 1)
                    break;
                if (nums[i] + i > candidateMaxIndex)
                    candidateMaxIndex = nums[i] + i;
            }
            maxIndex = candidateMaxIndex;
            startIndex = lastMaxIndex + 1;
            if (maxIndex >= nums.length - 1)
                return true;
            if (maxIndex == lastMaxIndex)
                return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,0,4,2,2,0,1,3,3,0,3};
        System.out.println(canJump(nums));
    }
}
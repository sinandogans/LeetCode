public class Main {
    public static int removeDuplicates(int[] nums) {
        int lengthCount = 1;
        int temp;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + lengthCount == nums.length) {
                result = i + 1;
                break;
            }
            if (nums[i] == nums[i + 1]) {
                nums[i + 1] = nums[nums.length - lengthCount];
                nums[nums.length - lengthCount] = nums[i];
                lengthCount++;
                i--;
            } else if (nums[i] > nums[i + 1]) {
                temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                i -= 2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        //input
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int result = removeDuplicates(nums);
    }

    // excellent solution from others
//    int i = 0;
//        for (int j = 1; j<nums.length;j++){
//        if(nums[i] != nums[j]){
//            i++;
//            nums[i] = nums[j];
//        }
//    }
//        return i+1;
}
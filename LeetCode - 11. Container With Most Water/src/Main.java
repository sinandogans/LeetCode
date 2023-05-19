public class Main {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int currentArea;
        int iter1 = 0;
        int iter2 = height.length - 1;
        while (iter1 < iter2) {
            if (height[iter1] >= height[iter2]) {
                currentArea = (iter2 - iter1) * height[iter2];
                iter2--;
            } else {
                currentArea = (iter2 - iter1) * height[iter1];
                iter1++;
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 1};
        int result = maxArea(height);
    }
}
import java.util.Arrays;

public class Main {
    //test
    public static void main(String[] args) {
        var intervals = new int[][]{
                {-36057, -16287},
                {-35323, -26257},
                {-27140, -14703},
                {-15279, 21851},
                {-15129, -5773},
                {-12098, 16264},
                {-8144, 1080},
                {-3035, 30075},
                {1937, 6906},
                {10508, 46685},
                {11834, 20971},
                {19621, 34415},
                {28565, 37578},
                {32985, 36313},
                {44578, 45600},
                {47939, 48626}
        };

        var result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

//algorithm
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int lastAddedIndex = 0;
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[lastAddedIndex][1]) {
                lastAddedIndex = i;
            } else if (intervals[i][0] < intervals[lastAddedIndex][1]) {
                if (intervals[i][1] < intervals[lastAddedIndex][1]) {
                    lastAddedIndex = i;
                }
                result++;
            }
        }

        return result;
    }
}
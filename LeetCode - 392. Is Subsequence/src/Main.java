public class Main {
    public static boolean isSubsequence(String s, String t) {
        int iterT = 0;
        int iterS = 0;
        int subsequenceCount = 0;
        int lengthOfS = s.length();
        int lengthOfT = t.length();
        while (iterT != lengthOfT && iterS != lengthOfS) {
            if (s.charAt(iterS) == t.charAt(iterT)) {
                subsequenceCount++;
                iterS++;
            }
            iterT++;
        }
        return subsequenceCount == lengthOfS;
    }

    public static void main(String[] args) {
        // sample inputs
        String s = "axc";
        String t = "ahbgdc";

        boolean output = isSubsequence(s, t);
        System.out.println(output);
    }
}
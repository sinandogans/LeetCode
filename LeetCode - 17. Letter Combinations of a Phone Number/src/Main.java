import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<String> letterCombinations(String digits) {
        String[][] lettersOfNumbers = {
                {},
                {},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}};

        List<String> result = new ArrayList<>();
        if (digits.isEmpty())
            return result;
        result = Arrays.stream(lettersOfNumbers[Integer.parseInt(String
                .valueOf(digits.charAt(0)))]).toList();

        for (int i = 1; i < digits.length(); i++) {
            result = combineLetters(result, lettersOfNumbers[Integer.parseInt(String
                    .valueOf(digits.charAt(i)))]);
        }
        return result;
    }

    public static List<String> combineLetters(List<String> letters1, String[] letters2) {
        var result = new ArrayList<String>();
        for (String c1 : letters1) {
            for (String c2 : letters2) {
                result.add(c1 + c2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("3"));
    }
}
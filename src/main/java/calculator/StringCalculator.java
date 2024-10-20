package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int calculate(String input) {
        if (isDefaultPattern(input)) {
            // 합해주는 메소드 구현 예정
        }
        if (isCustomPattern(input)) {
            // 합해주는 메소드 구현 예정
        }
        throw new IllegalArgumentException();
    }

    private static boolean isDefaultPattern(String input) {
        return matchPattern(input, "^\\d*([,:]\\d+)*$");
    }

    private static boolean isCustomPattern(String input) {
        return matchPattern(input, "^//(.)\\\\n\\d*(\\1\\d+)*$");
    }

    private static boolean matchPattern(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

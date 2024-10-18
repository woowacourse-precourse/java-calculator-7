package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public void validateInputFormat(String input) {
        if (input.startsWith("//")) {
            int count = countMatches(input, "//(.)\\\\n(.*?)");

            if (count != 1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    private int countMatches(String input, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}

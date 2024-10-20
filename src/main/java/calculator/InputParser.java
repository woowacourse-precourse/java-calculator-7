package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException("올바르지 않은 형식의 커스텀 구분자입니다. 커스텀 구분자는 하나의 문자여야 합니다.");
        }
    }

    public static String extractNumbersSection(String input) {
        if (input.startsWith("//")) {
            return input.split("\n", 2)[1];
        }
        return input;
    }
}

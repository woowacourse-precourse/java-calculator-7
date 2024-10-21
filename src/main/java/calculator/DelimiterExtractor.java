package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(input);
            if (matcher.find()) {
                return Pattern.quote(matcher.group(1));
            } else {
                throw new IllegalArgumentException("유효하지 않은 구분자 형식입니다.");
            }
        }
        return DEFAULT_DELIMITERS;
    }




    public String extractNumbers(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
            }
            return input.substring(delimiterEndIndex + 2); // "\\n" 이후의 문자열
        }
        return input;
    }

}

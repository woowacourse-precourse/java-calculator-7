package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n.*$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException("올바르지 않은 형식의 커스텀 구분자입니다. 커스텀 구분자는 하나의 문자여야 합니다.");
        }
    }

    public static String extractNumbersSection(String input) {
        // 이스케이프된 줄바꿈을 실제 줄바꿈으로 변환
        if (input.contains("\\n")) {
            input = input.replace("\\n", "\n");
        }

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);

            if (parts.length > 1) {
                return parts[1];
            } else {
                throw new IllegalArgumentException("올바르지 않은 형식의 입력입니다. 줄바꿈 문자가 없습니다.");
            }
        }
        return input;
    }
}

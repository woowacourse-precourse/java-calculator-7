package calculator.common;

import calculator.common.CustomExceptions.InvalidDelimiterFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    public static String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n.*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidDelimiterFormatException("커스텀 구분자의 형식이 잘못되었습니다.");
        }
        String delimiter = matcher.group(1);

        if (Character.isDigit(delimiter.charAt(0))) {
            throw new InvalidDelimiterFormatException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }

        return delimiter;
    }


    public static String extractNumbersSection(String input) {
        // 커스텀 구분자와 숫자 부분을 파싱하기 위해 줄바꿈 문자("\\n")를 실제 줄바꿈("\n")으로 변환
        if (input.contains("\\n")) {
            input = input.replace("\\n", "\n");
        }

        if (!input.startsWith("//")) {
            return input;
        }

        String[] parts = input.split("\n", 2);
        if (parts.length <= 1) {
            throw new IllegalArgumentException("커스텀 구분자의 형식이 잘못되었습니다.");
        }
        return parts[1];
    }
}

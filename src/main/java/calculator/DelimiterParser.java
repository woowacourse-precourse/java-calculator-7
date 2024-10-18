package calculator;

import java.util.regex.Pattern;

public class DelimiterParser {
    // 기본 구분자
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 입력에서 구분자를 추출하는 메서드
    public static String parse(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.contains("\\n") ? input.indexOf("\\n") : input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("유효하지 않은 구분자 형식입니다.");
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            return Pattern.quote(customDelimiter); // 여러 글자의 구분자를 안전하게 처리
        }
        return DEFAULT_DELIMITERS; // 기본 구분자 반환
    }

    // 입력에서 숫자 부분을 추출하는 메서드
    public static String extractNumbers(String input) {
        if (input.startsWith("//")) {
            int numbersStartIndex = input.contains("\\n") ? input.indexOf("\\n") + 2 : input.indexOf("\n") + 1;
            return input.substring(numbersStartIndex); // 구분자 이후 숫자 부분 반환
        }
        return input; // 기본 구분자 사용 시 전체 입력 반환
    }
}

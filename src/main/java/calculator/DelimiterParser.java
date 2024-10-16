package calculator;

import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//"; // 커스텀 구분자 접두사

    public String[] splitNumbers(String input) {
        String delimiter = ",|:"; // 기본 구분자. 정규표현식 사용
        String numbersPart = input; // 숫자 부분

        if (input.startsWith("//")) {
            int delimiterEndIndex = numbersPart.indexOf("\n");

            if (delimiterEndIndex == -1) {
                // 잘못된 입력. 예외 발생.
            }

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);

            // 기본 구분자와 커스텀 구분자를 합쳐서 정규표현식 생성
            delimiter += "|" + Pattern.quote(customDelimiter); // customDelimiter 이스케이프 처리
            numbersPart = input.substring(delimiterEndIndex + 1);
        }

        return numbersPart.split(delimiter);
    }
}

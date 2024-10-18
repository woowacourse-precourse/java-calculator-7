package calculator;

import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//"; // 커스텀 구분자 접두사

    public String[] splitNumbers(String input) {
        String delimiter = ",|:"; // 기본 구분자. 정규표현식 사용
        String numbersPart = input; // 숫자 부분

        if (input.startsWith("//")) {
            int delimiterEndIndex = numbersPart.indexOf("\\n");
            int numbersStartIndex = delimiterEndIndex + 2;

            // \n이 존재하지 않거나 //와 \n사이에 구분자가 없는 경우
            if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
                throw new IllegalArgumentException("잘못된 입력값입니다: " + input);
            }

            // 커스텀 구분자만 지정하고 숫자가 없는 경우(ex. "//;\\n")
            if (input.length() < numbersStartIndex) {
                return new String[]{};
            }

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);

            // 기본 구분자와 커스텀 구분자를 합쳐서 정규표현식 생성
            delimiter += "|" + Pattern.quote(customDelimiter); // customDelimiter 이스케이프 처리
            numbersPart = input.substring(numbersStartIndex);
        }

        return numbersPart.split(delimiter);
    }
}

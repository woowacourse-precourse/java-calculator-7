package calculator.extractor;

import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITERS = "[,:]";  // 기본 구분자 (쉼표, 콜론)

    public String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n"); //input은 문자 그대로 \n 으로 입력되기 때문에 구분자를 찾기 위해서는 \\n 으로 구분해야 한다.

            if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
                throw new IllegalArgumentException("잘못된 입력 형식: 커스텀 구분자가 누락되었거나 잘못된 형식입니다.");
            }

            // 커스텀 구분자 추출
            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자는 비워둘 수 없습니다.");
            }

            return Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS; // 정규식에서 안전하게 사용
        }

        return DEFAULT_DELIMITERS;  // 기본 구분자 사용
    }

}

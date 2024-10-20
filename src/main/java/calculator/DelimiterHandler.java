package calculator;

import java.util.regex.Pattern;

public class DelimiterHandler {

    private static final String DEFAULT_DELIMITER = ",|:";

    /**
     * 숫자들을 추출해내는 함수
     *
     * @param input 입력으로 받은 문자열
     * @return 숫자로 이루어진 문자열 리스트
     */
    public String[] extractNumbers(String input) {
        if (input.startsWith("//")) {
            return extractWithCustomDelimiter(input);
        } else {
            return extractWithDefaultDelimiters(input);
        }
    }

    /**
     * 기본 구분자(콤마, 콜론)로 문자열을 분리하는 함수
     *
     * @param input 입력으로 받은 문자열
     * @return 숫자로 이루어진 문자열 리스트
     */
    private String[] extractWithDefaultDelimiters(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    /**
     * 커스텀 구분자로 문자열을 분리하는 함수
     *
     * @param input 입력으로 받은 문자열
     * @return 숫자로 이루어진 문자열 리스트
     */
    private String[] extractWithCustomDelimiter(String input) {
        int customDelimiterIndex = input.indexOf("\\n");
        if (customDelimiterIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 맞지 않습니다.");
        }

        String customDelimiter = input.substring(2, customDelimiterIndex);

        if (customDelimiter.matches("\\d+")) {
            throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
        }

        String delimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);

        String numbersPart = input.substring(customDelimiterIndex + 2);
        return numbersPart.split(delimiter);
    }
}

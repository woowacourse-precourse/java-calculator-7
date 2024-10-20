package calculator;

import java.util.regex.Pattern;

public class CustomDelimiterParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private String delimiter = DEFAULT_DELIMITER;

    /**
     * 입력 문자열을 파싱하여 숫자 배열로 반환합니다.
     * 입력이 "//"로 시작하면 커스텀 구분자를 처리합니다.
     *
     * @param input 파싱할 입력 문자열
     * @return 구분자로 분리된 숫자 문자열 배열
     */
    public String[] parse(String input) {
        if (input.startsWith("//")) {
            input = handleCustomDelimiter(input);
        }
        return input.split(delimiter);
    }

    /**
     * 커스텀 구분자를 처리하고 실제 입력 문자열을 반환합니다.
     *
     * @param input 커스텀 구분자를 포함한 입력 문자열
     * @return 커스텀 구분자가 제거된 실제 입력 문자열
     * @throws IllegalArgumentException 커스텀 구분자 형식이 잘못된 경우
     */
    private String handleCustomDelimiter(String input) {
        int newLineIndex = input.indexOf("\\n");
        if (newLineIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 지정 후 \\n이 없습니다.");
        }

        String customDelimiter = input.substring(2, newLineIndex);
        validateCustomDelimiter(customDelimiter);

        delimiter += "|" + Pattern.quote(customDelimiter);
        return input.substring(newLineIndex + 2);
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
        if (customDelimiter.codePoints().count() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 정확히 하나의 유니코드 문자여야 합니다.");
        }
    }
}

package calculator;

public class Parser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    /* input이 빈 문자열이 아닌 경우
     * 커스텀 구분자 사용 시:
     * - (커스텀 구분자 시작, 커스텀 구분자 종료) = 정상 작동
     * - (커스텀 구분자 시작, 커스텀 구분자 끝 없음) = 에러
     * - (커스텀 구분자 시작 없음, 커스텀 구분자 끝 있음) = 에러
     * 커스텀 구분자 미사용 시:
     * - (커스텀 구분자 시작 없음, 커스텀 구분자 시작 있음) = 정상 작동
     */
    public static String[] parse(String input) {
        // 커스텀 구분자를 사용할 수 있는지 검증
        Validator.validateCustomDelimiterUsage(input, CUSTOM_DELIMITER_START, CUSTOM_DELIMITER_END);

        // 커스텀 구분자로 사용할 수 있고, 커스텀 구분자로 시작하는 경우
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_END);

            // 커스텀 구분자의 종료점 여부 검증
            Validator.validateCustomDelimiterPresence(2, delimiterIndex);

            // 커스텀 구분자의 종료점이 있는 경우
            String customDelimiter = input.substring(2, delimiterIndex);
            String regulatedInput = input.substring(delimiterIndex + 2);

            // 커스텀 구분자로 파싱하는 함수
            return splitUsingCustomDelimiter(customDelimiter, regulatedInput);
        }

        // 커스텀 구분자의 종료점이 없는 경우, 기본 구분자를 이용
        return new String[] {};
    }

    private static String[] splitUsingCustomDelimiter(String customDelimiter, String regulatedInput) {

        return new String[] {};
    }
}

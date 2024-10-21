package calculator;

/**
 * 문자열을 특정 구분자를 기준으로 분리하는 클래스. 기본 구분자는 쉼표(,)와 콜론(:)이며, 커스텀 구분자 지정 가능
 */
public class StringSplitter {

    // 기본 구분자 (쉼표, 콜론)
    private static final String DEFAULT_DELIMITERS = ",:";

    // 커스텀 구분자의 시작을 알리는 접두사
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    // 커스텀 구분자와 본문을 구분하는 끝 문자열
    private static final String DELIMITER_END = "\\n";

    /**
     * 문자열을 구분자로 분리 커스텀 구분자가 있으면 이를 기본 구분자와 함께 사용하고, 없으면 기본 구분자(쉼표, 콜론)만 사용
     *
     * @param input 분리할 입력 문자열
     * @return 분리된 문자열 배열
     */
    public String[] split(String input) {
        // 입력이 null이거나 빈 문자열일 경우 빈 배열 반환
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        // 커스텀 구분자를 사용하는 경우 처리
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String customDelimiter = extractCustomDelimiter(input);  // 커스텀 구분자 추출
            int contentStartIndex = input.indexOf(DELIMITER_END) + DELIMITER_END.length();  // 본문 시작 위치
            String combinedDelimiters = combineDelimiters(customDelimiter);  // 기본 구분자와 커스텀 구분자 결합
            return input.substring(contentStartIndex)
                    .split(combinedDelimiters);  // 구분자로 문자열 분리
        }

        // 기본 구분자를 사용하여 문자열 분리
        return input.split("[" + DEFAULT_DELIMITERS + "]");
    }

    /**
     * 입력 문자열에서 커스텀 구분자를 추출
     *
     * @param input 커스텀 구분자가 포함된 입력 문자열
     * @return 추출된 커스텀 구분자
     */
    private String extractCustomDelimiter(String input) {
        int startIndex = CUSTOM_DELIMITER_PREFIX.length();  // 커스텀 구분자 시작 위치
        int endIndex = input.indexOf(DELIMITER_END);  // 커스텀 구분자 끝 위치
        String customDelimiter = input.substring(startIndex, endIndex);  // 구분자 추출
        ExceptionHandler.handleInvalidDelmiter(customDelimiter);  // 구분자 검증
        return customDelimiter;
    }

    /**
     * 기본 구분자와 커스텀 구분자를 결합하여 하나의 정규식 패턴으로 반환합니다.
     *
     * @param customDelimiter 커스텀 구분자
     * @return 기본 구분자와 커스텀 구분자를 결합한 정규식 패턴
     */
    private String combineDelimiters(String customDelimiter) {
        StringBuilder combinedDelimiters = new StringBuilder(DEFAULT_DELIMITERS);
        for (char delimiter : customDelimiter.toCharArray()) {
            combinedDelimiters.append(escapeRegexChars(delimiter));  // 커스텀 구분자에 특수 문자 이스케이프 처리
        }
        // 정규식 패턴으로 반환 (구분자를 문자 그룹으로 처리)
        return "[" + combinedDelimiters + "]";
    }

    /**
     * 정규식 특수 문자인 경우 이스케이프 처리
     *
     * @param delimiter 구분자로 사용되는 문자
     * @return 이스케이프 처리된 문자
     */
    private String escapeRegexChars(char delimiter) {
        // 정규식에서 특수 문자인 경우 이스케이프 처리
        if (delimiter == '[' || delimiter == ']' || delimiter == '\\') {
            return "\\" + delimiter;
        }
        return Character.toString(delimiter);
    }
}

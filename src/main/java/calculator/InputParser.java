package calculator;

public class InputParser {

    // 기본 구분자 쉼표(,)와 콜론(:)
    private static final String DEFAULT_DELIMITER = ",|:";

    // 커스텀 구분자를 정의하는 접두사
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    // 커스텀 구분자를 정의하는 접미사 (\n)
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    /**
     * 입력 문자열에서 토큰을 추출합니다.
     * 기본 구분자를 사용하는지 커스텀 구분자를 사용하는지에 따라 분기됩니다.
     */
    public String[] parseTokens(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{"0"}; // 입력이 없을 경우 기본값 "0" 반환
        }

        return hasCustomDelimiter(input)
                ? parseCustomTokens(input)
                : parseDefaultTokens(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String[] parseDefaultTokens(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private String[] parseCustomTokens(String input) {

        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }
        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);

        // 정규식 메타문자를 이스케이프 처리
        customDelimiter = escapeSpecialRegexChars(customDelimiter);

        return input.substring(delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length()).split(customDelimiter);
    }

    /**
     * 정규식에서 메타문자로 사용되는 특수 문자를 이스케이프 처리
     *
     * @param delimiter 사용자 정의 구분자
     * @return 이스케이프 처리된 구분자
     */
    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\.^$*+?(){}|\\[\\]\\\\])", "\\\\$1");
    }
}

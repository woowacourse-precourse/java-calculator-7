package calculator;

public class CustomDelimiter implements Delimiter {

    private static final int CUSTOM_DELIMITER_START_INDEX = 2; // 커스텀 구분자가 시작하는 인덱스
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;   // 커스텀 구분자가 끝나는 인덱스
    private static final int CUSTOM_DELIMITER_EXPRESSION_LENGTH = 4; // "//?\n" 표현의 길이
    private static final String[] META_CHARACTERS = {".", "*", "+", "?", "|", "^", "$", "(", ")", "[", "]", "{", "}",
            "\\"};

    private String delimiters = ",|:";

    public CustomDelimiter() {
        super();
    }

    @Override
    public String getDelimiters() {
        return delimiters;
    }

    @Override
    public String parseDelimiter(String input) {
        if (isValidExpression(input)) {
            // todo : 커스텀 구분자가 1문자 이상인 경우 예외 처리(리팩토링 중 유실됨,
            // todo : //와 \\n 기준으로 동적으로 진행되게 해야하는지 검토 필요
            if (input.length() < CUSTOM_DELIMITER_EXPRESSION_LENGTH) {
                throw new IllegalArgumentException("커스텀 구분자는 최소 한 문자가 있어야 합니다.");
            }

            String customDelimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);

            // 숫자가 구분자로 입력된 경우 예외 처리
            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자로 숫자가 입력되었습니다.");
            }

            customDelimiter = escapeMetaCharacters(customDelimiter);
            delimiters += "|" + customDelimiter;  // 기본 구분자에 커스텀 구분자 추가
            return input.substring(CUSTOM_DELIMITER_EXPRESSION_LENGTH + 1); // 커스텀 구분자를 제외한 나머지 문자열 반환
        }

        throw new IllegalArgumentException("유효하지 않은 커스텀 구분자 표현입니다.");
    }

    private boolean isValidExpression(String input) {
        // 커스텀 구분자 표현이 "//"로 시작하고 "\n"을 포함하는지 확인
        return input.startsWith("//") && input.contains("\\n");
    }

    private String escapeMetaCharacters(String customDelimiter) {
        for (String metaChar : META_CHARACTERS) {
            if (customDelimiter.equals(metaChar)) {
                return "\\" + customDelimiter;  // 메타 문자가 있다면 이스케이프 처리
            }
        }
        return customDelimiter;
    }
}

package calculator;

public class CustomDelimiter implements Delimiter {
    private static final String ERROR_INVALID_DELIMITER_EXPRESSION = "유효하지 않은 커스텀 구분자 표현입니다.";
    private static final String ERROR_NUMBER_AS_DELIMITER = "커스텀 구분자로 숫자가 입력되었습니다.";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2; // 커스텀 구분자 시작 인덱스
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;   // 커스텀 구분자 종료 인덱스
    private static final int CUSTOM_DELIMITER_EXPRESSION_LENGTH = 4; // "//?\n" 표현의 길이

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
        if (isCustomDelimiterExpression(input)) {
            // todo : 커스텀 구분자가 1문자 이상인 경우 예외 처리(리팩토링 중 유실됨,
            // todo : //와 \\n 기준으로 동적으로 진행되게 해야하는지 검토 필요
            if (input.length() < CUSTOM_DELIMITER_EXPRESSION_LENGTH) {
                throw new IllegalArgumentException("커스텀 구분자는 최소 한 문자가 있어야 합니다.");
            }

            String customDelimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);

            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw new IllegalArgumentException(ERROR_NUMBER_AS_DELIMITER);
            }

            customDelimiter = MetaCharacterUtil.escapeMetaCharacters(customDelimiter);
            delimiters += "|" + customDelimiter;  // 기본 구분자에 커스텀 구분자 추가
            return input.substring(CUSTOM_DELIMITER_EXPRESSION_LENGTH + 1); // 커스텀 구분자를 제외한 나머지 문자열 반환
        }

        throw new IllegalArgumentException(ERROR_INVALID_DELIMITER_EXPRESSION);
    }

    private boolean isCustomDelimiterExpression(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }
}

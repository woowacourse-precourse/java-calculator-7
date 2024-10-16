package calculator.message;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String NEW_LINE = "\n";
    public static final String EMPTY_INPUT_MESSAGE = ERROR_PREFIX + " 문자열이 비어 있습니다." + NEW_LINE;
    public static final String EMPTY_ELEMENT_MESSAGE = ERROR_PREFIX + " 구분자를 연속으로 두 개 사용할 수 없습니다." + NEW_LINE;
    public static final String INVALID_ELEMENT_MESSAGE = ERROR_PREFIX + " 구분자를 제외하고는 숫자만 입력하셔야 합니다." + NEW_LINE;
    public static final String NEGATIVE_NUMBER_MESSAGE = ERROR_PREFIX + " 양수만 입력하셔야 합니다." + NEW_LINE;
}
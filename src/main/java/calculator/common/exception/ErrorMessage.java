package calculator.common.exception;

public final class ErrorMessage {

    public static final String INPUT_BLANK_ERROR = "[Error] 빈 문자열은 입력할 수 없습니다.";
    public static final String INPUT_NOT_SUPPORTED_CHAR_ERROR = "[Error] 구분자가 아닌 특수문자는 입력할 수 없습니다.";
    public static final String INPUT_ZERO_OR_NEGATIVE_VALUE_ERROR = "[Error] 양수만 입력 가능합니다.";

    public static final String SEPARATOR_FORMAT_ERROR = "[Error] 구분자는 하나의 문자여야 합니다.";
    public static final String SEPARATOR_DUPLICATION_ERROR = "[Error] 이미 등록된 구분자입니다.";
}

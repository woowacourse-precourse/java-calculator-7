package calculator.constant;

public final class ErrorMessages {

    public static final String EMPTY_INPUT_MESSAGE = "입력값이 없습니다";
    public static final String INVAILD_CHAR_MESSAGE = "'/'와'\\'는 커스텀 구분자를 등록하는 데에만 사용할 수 있습니다";
    public static final String NUMBER_ASSIGN_ERROR_MESSAGE = "커스텀 구분자에 숫자는 등록할 수 없습니다";
    public static final String INVALID_DELIMITER_MESSAGE = "구분자나 숫자가 아닌 문자가 발견되었습니다: ";

    private ErrorMessages() {
        throw new UnsupportedOperationException("이 클래스는 인스턴스화 할 수 없습니다");
    }
}

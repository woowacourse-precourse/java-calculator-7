package calculator;

public class ErrorMessages {
    static final String ERROR_NO_EXPRESSION_CUSTOM_DELIMITER = "커스텀 구분자 이후로 수식이 없습니다";
    static final String ERROR_CUSTOM_DELIMITER_OVER_TWO = "커스텀 구분자가 2개이상 있습니다";
    static final String ERROR_CUSTOM_DELIMITER_NOT_START_WITH_FORMAT = "커스텀 구분자의 형식인 //로 시작하지 않습니다";
    static final String ERROR_CUSTOM_DELIMITER_CONTAIN_NUMBER = "구분자에 숫자가 들어있습니다";
    static final String ERROR_NOT_CONTAIN_DELIMITER = "구분자가 없습니다";
    static final String ERROR_BASIC_DELIMITER_ONLY_DELIMITER_SUPPORT = " 밖에 없습니다";
    static final String ERROR_OPERANDS_CONTAIN_OTHER_CHAR = "피연산자에 숫자가 아닌 다른 문자가 있습니다";
    static final String ERROR_OPERANDS_CONTAIN_ZERO = "피연산자들 중 0이 있습니다";
    static final String ERROR_OPERANDS_CONTAIN_MINUS = "피연산자가 중 음수가 있습니다";

    private ErrorMessages() {
    }
}

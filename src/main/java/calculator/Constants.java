package calculator;

public class Constants {
    public static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해주세요.";
    public static final String OUTPUT_MESSAGE = "결과 : ";

    public static final String DEFAULT_SEPARATOR_COMMA = ",";
    public static final String DEFAULT_SEPARATOR_COLON = ":";
    public static final String CUSTOM_SEPARATOR_PREFIX = "//";
    public static final String CUSTOM_SEPARATOR_POSTFIX = "\\n";
    public static final String DEFAULT_INPUT = "base";

    public static final String VALID_DEFAULT_INPUT_REGEX = "[1-9,:]+";
    public static final String VALID_OPERAND_REGEX = "[1-9]+";
    public static final String WHITESPACE_REGEX = "\\s+";

    public static final String ERROR_INVALID_FORMAT = "입력 형식이 유효하지 않습니다.";
    public static final String ERROR_EMPTY_SEPARATOR = "커스텀 구분자는 빈 문자열이어서는 안 됩니다.";
    public static final String ERROR_ONE_CHAR_SEPARATOR = "커스텀 구분자는 한자리여야 합니다.";
    public static final String ERROR_ASCII_ONLY = "커스텀 구분자는 아스키 문자여야 합니다.";
    public static final String ERROR_CONTROL_CHAR = "커스텀 구분자는 아스키 제어 문자가 될 수 없습니다.";
    public static final String ERROR_WHITESPACE = "커스텀 구분자의 공백은 스페이스(Space)만 허용합니다.";
    public static final String ERROR_NUMERIC_SEPARATOR = "커스텀 구분자는 숫자 1~9가 될 수 없습니다.";
    public static final String ERROR_INVALID_OPERAND = "피연산자는 1~9의 숫자로만 이루어져야 합니다.";

    public static final int ASCII_MAX = 127;
    public static final int CONTROL_CHAR_MAX = 31;
    public static final int DEL_CHAR = 127;
    public static final int SPACE_CHAR = 32;
    public static final int DIGIT_MIN = 49;
    public static final int DIGIT_MAX = 57;
}

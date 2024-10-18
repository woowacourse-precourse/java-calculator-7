package calculator.util;

public class Const {

    private Const() { }

    public static final String PREFIX = "//";
    public static final String SUFFIX = "\\n";
    public static final String EMPTY = "";

    public static final String PREFIX_ERROR_MESSAGE = "// 로 시작되어야 합니다.";
    public static final String NUMERIC_ERROR_MESSAGE = "숫자는 구분자로 사용 불가능합니다.";
    public static final String STRING_ERROR_MESSAGE = "문자는 구분자로 사용 불가능합니다.";
    public static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 입력할 수 없습니다.";
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    public static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE_FORMAT = "결과 : %d\n";

    public static final String DELIMITER_JOINER = "|";
    public static final String COMMA = ",";
    public static final String COLON = ":";

    public static final String NUMERIC_REGEX = "[0-9]+";
    public static final String STRING_REGEX = "[a-zA-Z가-힣]+";

    public static final int DEFAULT_DELIMITER_SIZE = 2;
    public static final int PREFIX_SIZE = 2;
    public static final int SUFFIX_SIZE = 2;
    public static final int ZERO = 0;

}

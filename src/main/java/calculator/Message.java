package calculator;

public class Message {
    // error messages
    public static final String ERR_MSG_WHEN_FAIL_TO_PARSE_NUMBER = "숫자가 아닌 값이 입력되었습니다.";
    public static final String ERR_MSG_WHEN_NEGATIVE_NUMBER = "음수는 입력할 수 없습니다.";
    public static final String ERR_MSG_WHEN_DELIMITER_CONSISTS_OF_RESERVED_CHAR = "수 표기에 사용하는 문자는 구분자로 사용할 수 없습니다.";
    public static final String ERR_MSG_WHEN_WRONG_SYNTAX = "문법에 맞지 않는 입력입니다.";

    // user interface messages
    public static final String USER_INPUT_PROMPT_MSG = "덧셈할 문자열을 입력해 주세요.";
    public static final String PROGRAM_OUTPUT_FORMAT = "결과 : %s\n";
    public static final String SUM_RESULT_FORMAT = "#.#####";
}

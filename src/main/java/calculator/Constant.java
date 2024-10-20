package calculator;

public class Constant {

    // 입출력 템플릿
    public static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_RESULT = "결과 : ";

    // 검증 문구 템플릿
    public static final String INVALID_VALUE_IN_NUMBER_EXTRACTION = "숫자 추출에서 유효하지 않은 값이 검출되었습니다.";
    public static final String BOTH_ENDS_OF_THE_STRING_MUST_BE_A_NUMBER = "문자열의 시작과 끝에는 숫자가 와야 합니다.";
    public static final String SEPARATORS_CANNOT_COME_IN_SUCCESSION = "구분자는 연속해서 올 수 없습니다.";

    // 기본 구분자
    public static final String BASIC_DELIMITER_1 = ",";
    public static final String BASIC_DELIMITER_2 = ":";

    // 커스텀 구분자 지정
    public static final String CUSTOM_DELIMITER_START = "//";
    public static final String CUSTOM_DELIMITER_END = "\\n";

    public static final String REGEX_PIPE_OPERATOR = "|";
}

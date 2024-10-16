package calculator.helper;

public class InputHelper {
    public static final String SPLITTER_START = "//";
    public static final String SPLITTER_START_REGEX = "//";


    //이스케이프 문자 처리 및 regex에서 사용 구분
    public static final String SPLITTER_END = "\\n";
    public static final String SPLITTER_END_REGEX = "\\\\n";
    public static final int SPLITTED_START_IDX = 0;
    public static final int SPLITTED_END_IDX = 3;

    public static final String BASE_SPLITTER = "[,:]";

    public static final String INPUT_CALCULATE_STR = "덧셈할 문자열을 입력해 주세요.";

    public static final String INVALID_INPUT = "유효하지 않은 입력입니다";

    public static final String INVALID_CUSTOM_SPLITTER = "유효하지 않은 커스텀 지정자입니다.";




}

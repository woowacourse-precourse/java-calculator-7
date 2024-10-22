package calculator;

public class Constants {
    public static final String USER_INPUT_REQUEST_STRING = "덧셈할 문자열을 입력해 주세요.";
    public static final String SPECIAL_CHARACTER_REGEX = "^[~!@#$%^&*()_\\-+={\\[}\\]|\\\\<,>.?/:;\"']+$";
    public static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "허용된 특수문자가 아닙니다.";
    public static final String CUSTOM_SPECIAL_CHARACTER_ERROR_MESSAGE = "커스텀 구분자는 \"[//특수문자n]\" 형식으로 첫 문장에 추가해야 합니다.";
    public static final String DEFAULT_CUSTOM_SEPARATOR = ",;";
    public static final String CALCULATOR_RESULTS_OUTPUT_MESSAGE = "결과 : ";
}

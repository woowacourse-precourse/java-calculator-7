package calculator;

public class Constants {
    public static final String MESSAGE_START_INPUT = "덧셈할 문자열을 입력해 주세요.";
    public static final String MESSAGE_RESULT_FORMAT = "결과 : %d";

    public static final String ERROR_MISSING_NUMBER = "덧셈할 양수를 포함하여 입력해 주세요";
    public static final String ERROR_MISSING_DEFAULT_SEPARATOR = "구분자(쉼표, 콜론)를 포함하여 입력해 주세요";
    public static final String ERROR_ONLY_CUSTOM_SEPARATOR = "커스텀 구분자를 지정하면, 커스텀 구분자만 사용해 주세요.";
    public static final String ERROR_ONLY_NUMBER_AND_DEFAULT_SEPARATOR = "양수와 구분자(쉼표, 콜론)만 입력 가능합니다.";
    public static final String ERROR_INVALID_CUSTOM_FORMAT = "커스텀 구분자를 지정하려면, 다음의 형식으로 입력해주세요." + "\n" + "//커스텀 구분자\\n덧셈할 문자열";
    public static final String ERROR_INVALID_NUMBER_RANGE = "덧셈할 숫자는 양수만 입력해 주세요.";
    public static final String ERROR_INVALID_VALUES = "구분자와 양수로 구성된 문자열을 입력해 주세요.";

    public static final String REGEX_DEFAULT_SEPARATOR = "[,:]";
    public static final String REGEX_DEFAULT_FORMAT = "(?=.*[0-9])(?=.*[,:]).{2,}";
    public static final String REGEX_CUSTOM_FORMAT = "//(.*)\\\\n(.*)";
    public static final String REGEX_FIND_NUMBER = "(?=.*[0-9])(.*)";
    public static final String REGEX_FIND_NEGATIVE_NUMBER = "(?=.*-[1-9]).*";
    public static final String REGEX_FIND_DEFAULT_SEPARATOR = "(?=.*[,:]).*";
    public static final String REGEX_FIND_INVALID_CHARACTER = "(?=.*[^,:0-9]).*";
    public static final String REGEX_CUSTOM_SEPARATOR_IS_MINUS_SIGN = "//-\\\\n(.*)";

    private Constants() {
    }
}

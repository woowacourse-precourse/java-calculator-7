package calculator;

public final class Constants {
    public static final String MESSAGE_START_INPUT = "덧셈할 문자열을 입력해 주세요.";
    public static final String MESSAGE_RESULT_FORMAT = "결과 : %d";

    public static final String ERROR_MISSING_DEFAULT_SEPARATOR = "구분자(쉼표, 콜론)를 포함하여 입력해 주세요";
    public static final String ERROR_INVALID_CUSTOM_FORMAT = "커스텀 구분자를 지정하려면, 다음의 형식으로 입력해 주세요." + "\n" + "//커스텀 구분자\\n덧셈할 문자열";
    public static final String ERROR_INVALID_NUMBER_RANGE = "덧셈할 숫자는 양수만 입력해 주세요.";

    public static final String REGEX_DEFAULT_SEPARATOR = "[,:]";
    public static final String REGEX_DEFAULT_FORMAT = "(?=.*[0-9])(?=.*[,:]).{2,}";
    public static final String REGEX_CUSTOM_FORMAT = "//(.*)\\\\n(.*)";
    public static final String REGEX_FIND_NEGATIVE_NUMBER = "(?=.*-[1-9]).*";
    public static final String REGEX_FIND_DEFAULT_SEPARATOR = "(?=.*[,:]).*";

    public boolean isDefaultFormat(String input) {
        return input.matches(Constants.REGEX_DEFAULT_FORMAT);
    }

    private boolean isCustomFormat(String input) {
        return input.matches(Constants.REGEX_CUSTOM_FORMAT);
    }

    private Constants() {
    }
}

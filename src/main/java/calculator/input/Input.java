package calculator.input;

public class Input {

    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final int CUSTOM_LENGTH = 5;

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

    private final String nums;

    protected Input(String nums) {
        validateNums(nums);
        this.nums = nums;
    }

    public static Input of(String input) {
        if (isCustom(input)) {
            String custom = input.substring(0, CUSTOM_LENGTH);
            String numInput = input.substring(CUSTOM_LENGTH);
            char separator = getCustomSeparator(custom);
            return new CustomInput(numInput, separator);
        }
        return new Input(input);
    }

    private static boolean isCustom(String input) {
        if (input.length() < CUSTOM_LENGTH) {
            return false;
        }
        String customPrefix = input.substring(0, CUSTOM_PREFIX.length());
        String customSuffix = input.substring(CUSTOM_PREFIX.length() + 1, CUSTOM_LENGTH);
        return customPrefix.equals(CUSTOM_PREFIX) && customSuffix.equals(CUSTOM_SUFFIX);
    }

    private static char getCustomSeparator(String custom) {
        return custom.charAt(CUSTOM_PREFIX.length());
    }

    private void validateNums(String numInput) {
        if (!numInput.isEmpty() && !isNum(numInput.charAt(0))) {
            throw new IllegalArgumentException("입력 문자열의 형식이 유효하지 않습니다.");
        }
    }

    private boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }
}

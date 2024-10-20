package calculator.input;

public class InputFilter {

    private static final String CUSTOM_REGEX = "^//.\\\\n.*";
    private static final int CUSTOM_PREFIX_LENGTH = 2;
    private static final int CUSTOM_LENGTH = 5;

    private InputFilter() {}

    public static Input parseInput(String value) {
        if (isCustom(value)) {
            return CustomInput.from(removeCustom(value), getCustomSeparator(value));
        }
        return new Input(value);
    }

    private static boolean isCustom(String value) {
        return value.matches(CUSTOM_REGEX);
    }

    private static String removeCustom(String value) {
        return value.substring(CUSTOM_LENGTH);
    }

    private static String getCustomSeparator(String value) {
        return String.valueOf(value.charAt(CUSTOM_PREFIX_LENGTH));
    }
}

package validator;

public class InputValidator {

    private static final String REGEX_DELIMITER = "[,:]";

    private static final String REGEX_CUSTOM_DELIMITER = "[\'\",;:\\.\\*\\+\\?\\[\\]\\{\\}\\(\\)" +
            "\\\\\\|\\^\\$\\!\\@\\#\\$\\`\\~]";

    private static final String REGEX_CUSTOM_DELIMITER_START = "//";
    private static final String REGEX_CUSTOM_DELIMITER_END = "\\n";

    public static void checkInput(final String input) {
        hasNumber(input);
        hasSeparator(input);
    }

    private static void hasNumber(final String input) {
        for (char value : input.toCharArray()) {
            if (Character.isDigit(value)) {
                return;
            }
        }

        throw new IllegalArgumentException("양수도 함께 입력해야 합니다.");
    }

    private static void hasSeparator(final String inputs) {
        if(inputs.contains(REGEX_CUSTOM_DELIMITER_START) && inputs.contains(REGEX_CUSTOM_DELIMITER_END)) {
            hasCustomSeparator(inputs);
            return;
        }

        hasDefaultSeparator(inputs);
    }

    private static void hasCustomSeparator(String inputs) {
        inputs = inputs.replace(REGEX_CUSTOM_DELIMITER_START,"").replace(REGEX_CUSTOM_DELIMITER_END,"");
        for (String input : inputs.split("")) {
            if (input.matches(REGEX_CUSTOM_DELIMITER)) {
                return;
            }
        }

        throw new IllegalArgumentException("올바른 구분자도 함께 입력해야 합니다.");
    }

    private static void hasDefaultSeparator(final String inputs) {
        for (String input : inputs.split("")) {
            if (input.matches(REGEX_DELIMITER)) {
                return;
            }
        }

        throw new IllegalArgumentException("올바른 구분자도 함께 입력해야 합니다.");
    }
}

package validator;

import static constants.Constants.CUSTOM_START_TEXT;
import static constants.Constants.EMPTY_TEXT;

public class InputValidator {

    private static final String REGEX_DELIMITER = "[,:]";

    private static final String REGEX_CUSTOM_DELIMITER = "[\'\",;:\\-\\.\\*\\+\\?\\[\\]\\{\\}\\(\\)" +
            "\\|\\^\\$\\!\\@\\#\\&\\`\\~\\=\\`\\~\\<\\>\\/\\\\]";

    private static final String CUSTOM_END_TEXT = "\\n";
    private static final String MINUS_DELIMITER = "-";

    private static boolean isMinusDelimiter = false;

    public static void checkInput(final String input) {
        hasNumberAndDelimiter(input);
        hasNumber(input);
        hasDelimiter(input);
        hasMinusNumber(input);
    }

    private static void hasNumberAndDelimiter(final String inputs) {
        if (inputs.length() == 0 || inputs.contains(" ")) {
            throw new IllegalArgumentException("올바른 구분자와 양수를 입력해야 합니다.");
        }
    }

    private static void hasNumber(final String input) {
        for (char value : input.toCharArray()) {
            if (Character.isDigit(value)) {
                return;
            }
        }

        throw new IllegalArgumentException("양수도 함께 입력해야 합니다.");
    }

    private static void hasDelimiter(final String inputs) {
        if (inputs.contains(CUSTOM_START_TEXT) && inputs.contains(CUSTOM_END_TEXT)) {
            hasCustomDelimiter(inputs);
            return;
        }

        hasDefaultDelimiter(inputs);
    }

    private static void hasCustomDelimiter(String inputs) {
        inputs = inputs.replace(CUSTOM_START_TEXT, EMPTY_TEXT).replace(CUSTOM_END_TEXT, EMPTY_TEXT);
        for (String input : inputs.split(EMPTY_TEXT)) {
            if (input.matches(REGEX_CUSTOM_DELIMITER)) {
                if (input.contains(MINUS_DELIMITER)) isMinusDelimiter = true;
                return;
            }
        }

        throw new IllegalArgumentException("올바른 구분자도 함께 입력해야 합니다.");
    }

    private static void hasDefaultDelimiter(final String inputs) {
        for (String input : inputs.split("")) {
            if (input.matches(REGEX_DELIMITER)) {
                return;
            }
        }

        throw new IllegalArgumentException("올바른 구분자도 함께 입력해야 합니다.");
    }

    private static void hasMinusNumber(final String inputs) {
        String[] inputArray = inputs.split(EMPTY_TEXT);
        for (int i = 1; i < inputArray.length; i++) {
            checkMinusNumber(inputArray[i].charAt(0), inputArray[i - 1].charAt(0));
        }
    }

    private static void checkMinusNumber(final char currentValue, final char beforeValue) {
        if (Character.isDigit(currentValue)) {
            if (!isMinusDelimiter && MINUS_DELIMITER.equals(String.valueOf(beforeValue))) {
                throw new IllegalArgumentException("양수를 입력해야 합니다.");
            }
        }

        if (MINUS_DELIMITER.equals(String.valueOf(currentValue))) {
            if (isMinusDelimiter && MINUS_DELIMITER.equals(String.valueOf(beforeValue))) {
                throw new IllegalArgumentException("양수를 입력해야 합니다,");
            }
        }
    }
}

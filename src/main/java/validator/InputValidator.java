package validator;

public class InputValidator {

    private static final String REGEX_DELIMITER = "[,:]";

    private static final String REGEX_CUSTOM_DELIMITER = "[\'\",;:\\.\\*\\+\\?\\[\\]\\{\\}\\(\\)" +
            "\\\\\\|\\^\\$\\!\\@\\#\\$\\`\\~]";

    private static final String REGEX_CUSTOM_DELIMITER_START = "//";
    private static final String REGEX_CUSTOM_DELIMITER_END = "\\n";
    private static final String MINUS_NUMBER = "-";

    public static void checkInput(final String input) {
        hasNumberAndSeparator(input);
        hasNumber(input);
        hasSeparator(input);
        hasMinusNumber(input);
    }

    private static void hasNumberAndSeparator(final String inputs) {
        if(inputs.length() == 0 || inputs.contains(" ")) {
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

    private static void hasMinusNumber(final String inputs) {
        String[] inputArray = inputs.split("");
        for(int i = 1; i < inputArray.length; i++){
            checkMinusNumber(inputArray[i].charAt(0), inputArray[i-1].charAt(0));
        }
    }

    private static void checkMinusNumber(final char firstValue, final char secondValue) {
        if(Character.isDigit(firstValue)) {
            if(MINUS_NUMBER.equals(String.valueOf(secondValue))) {
                throw new IllegalArgumentException("양수를 입력해야 합니다.");
            }
        }
    }
}

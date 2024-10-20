package calculator.validator;

public class UserInputValidator {
    private static final String NON_NUMBER_FORMAT_EXCEPTION_MESSAGE = "정수를 입력해주세요.";

    private UserInputValidator() {
        throw new IllegalStateException("Validate Class");
    }

    public static void validateUserInput(String[] splitString) {
        validateIntegerInput(splitString);
    }

    private static void validateIntegerInput(String[] splitString) {
        for (String str : splitString) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NON_NUMBER_FORMAT_EXCEPTION_MESSAGE);
            }
        }
    }
}

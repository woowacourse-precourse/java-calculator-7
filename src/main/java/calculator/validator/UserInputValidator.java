package calculator.validator;

public class UserInputValidator {
    private static final String NON_NUMBER_FORMAT_EXCEPTION_MESSAGE = "정수를 입력해주세요.";
    private static final String NEGATIVE_NUMBER_MESSAGE = "양수만 입력해주세요";

    private UserInputValidator() {
        throw new IllegalStateException("Validate Class");
    }

    public static void validateUserInput(String[] splitString) {
        validateIntegerInput(splitString);
        validateNegativeInteger(splitString);
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

    private static void validateNegativeInteger(String[] splitString) {
        for (String str : splitString) {
            int i = Integer.parseInt(str);
            if (i < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
            }
        }
    }
}

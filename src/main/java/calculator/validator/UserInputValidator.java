package calculator.validator;

public class UserInputValidator {
    private static final String NEGATIVE_NUMBER_MESSAGE = "양수만 입력해주세요";

    private UserInputValidator() {
        throw new IllegalStateException("Validate Class");
    }

    public static void validateNegativeInteger(Integer[] parsedNumbers) {
        for (Integer parsedNum : parsedNumbers) {
            if (parsedNum < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
            }
        }
    }
}

package calculator.validator;

import static calculator.config.SystemConstantMessages.VALIDATOR_CLASS_MESSAGE;

public class UserInputValidator {
    private static final String NEGATIVE_NUMBER_MESSAGE = "양수만 입력해주세요";

    private UserInputValidator() {
        throw new IllegalStateException(VALIDATOR_CLASS_MESSAGE);
    }

    public static void validateNegativeInteger(Integer[] parsedNumbers) {
        for (Integer parsedNum : parsedNumbers) {
            if (parsedNum < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
            }
        }
    }
}

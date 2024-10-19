package calculator.validator;

import calculator.exception.ValidatorException;

import static calculator.constant.ErrorMessage.PREFIX;
import static calculator.constant.Limit.DEFAULT_VALUE;

public class InputValidator {
    public static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    public static final String CHAR_ONLY_CAN_USE_AS_CUSTOM = "문자는 커스텀 구분자로 지정 후 사용할 수 있습니다.";
    public static final String ONLY_POSITIVE = "양수만 계산 가능합니다.";

    public int validate(String input) {
        int result = DEFAULT_VALUE;

        if (input == null || input.isBlank()) {
            return result;
        }

        if (!input.matches(ONLY_NUMBER_REGEX)) {
            throw new ValidatorException(PREFIX + CHAR_ONLY_CAN_USE_AS_CUSTOM);
        }

        if (Integer.parseInt(input) < DEFAULT_VALUE) {
            throw new ValidatorException(PREFIX + ONLY_POSITIVE);
        } // end if

        result = Integer.parseInt(input);
        return result;
    } // validate
} // class
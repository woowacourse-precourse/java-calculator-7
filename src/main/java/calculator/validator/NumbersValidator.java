package calculator.validator;

import calculator.exception.ValidatorException;

import java.util.List;

import static calculator.constant.ErrorMessage.PREFIX;
import static calculator.constant.Limit.DEFAULT_VALUE;

public class NumbersValidator {
    public static final int NUMBER_RANGE_LIMIT = 200_000_000;
    public static final int NUMBER_SIZE_LIMIT = 10;
    public static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    public static final String CHAR_ONLY_CAN_USE_AS_CUSTOM = "문자는 커스텀 구분자로 지정 후 사용할 수 있습니다.";
    public static final String ONLY_POSITIVE = "양수만 계산 가능합니다.";
    public static final String NUMBER_RANGE_LIMIT_MESSAGE = "입력 가능한 숫자의 최대 범위는 20억입니다.";
    public static final String NUMBER_SIZE_LIMIT_MESSAGE = "입력 가능한 숫자의 개수는 최대 10개입니다.";

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

        if (Integer.parseInt(input) > NUMBER_RANGE_LIMIT) {
            throw new ValidatorException(PREFIX + NUMBER_RANGE_LIMIT_MESSAGE);
        } // end if

        result = Integer.parseInt(input);
        return result;
    } // validate

    public void validate(List<Integer> input) {
        if (input.size() > NUMBER_SIZE_LIMIT) {
            throw new ValidatorException(PREFIX + NUMBER_SIZE_LIMIT_MESSAGE);
        } // end if

        if (input.stream().anyMatch(number -> number > NUMBER_RANGE_LIMIT)) {
            throw new ValidatorException(PREFIX + NUMBER_RANGE_LIMIT_MESSAGE);
        } // end if
    } // validate
} // class
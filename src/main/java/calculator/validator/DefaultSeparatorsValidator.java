package calculator.validator;

import calculator.constant.ErrorMessage;
import calculator.exception.ValidatorException;

public class DefaultSeparatorValidator {
    public static final String CONTAINS_DEFAULT_SEPARATOR_REGEX = "^[0-9,:]+$";
    public static final String DEFAULT_ONLY_CAN_USE_THESE = "기본 구분자는 ,과 :만 사용 가능합니다.";

    public void validate(String input) {
        if (!input.matches(CONTAINS_DEFAULT_SEPARATOR_REGEX)) {
            throw new ValidatorException(ErrorMessage.PREFIX + DEFAULT_ONLY_CAN_USE_THESE);
        } // end if
    } // validate
} // class
package calculator.domain;

import calculator.common.ErrorMessage;

public interface Delimiter {

    boolean supports(String input);

    String[] split(String input);

    default void validate(String input) {
        if (!supports(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR);
        }
    }
}

package calculator.validation;

import static calculator.constant.ErrorMessage.INVALID_INPUT;
import static calculator.constant.ErrorMessage.NEGATIVE_NUMBER;

public class NumberValidator implements Validator {
    @Override
    public void validate(Object target) {
        if (!(target instanceof Integer)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        int number = (Integer) target;
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }
}

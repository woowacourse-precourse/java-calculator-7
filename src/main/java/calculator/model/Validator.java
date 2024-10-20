package calculator.model;

import static calculator.Constant.CANNOT_INPUT_NEGATIVE_NUMBER;
import static calculator.Constant.ONLY_CAN_INPUT_NUMBER;

public class Validator {
    public void validateInputNumber(String[] splitNumber) {
        for (String number : splitNumber) {
            validateSingleNumber(number.trim());
        }
    }

    public void validateSingleNumber(String number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(ONLY_CAN_INPUT_NUMBER);
        }
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException(CANNOT_INPUT_NEGATIVE_NUMBER);
        }
    }

    private boolean isValidNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

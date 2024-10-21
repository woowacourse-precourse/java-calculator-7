package calculator.util;

import static calculator.constant.ErrorMessages.INVALID_NUMBER_FORMAT;
import static calculator.constant.ErrorMessages.NEGATIVE_NUMBER_NOT_ALLOWED;

public class NumberValidator {

    public static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }

            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
            }
        }
    }
}

package calculator.model;

import calculator.common.ErrorMessage;
import java.math.BigInteger;
import java.util.Arrays;

public class StringToNumberConverter {
    public long[] convertToNumbers(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .mapToLong(this::parseLongWithValidation)
                .toArray();
    }

    private long parseLongWithValidation(String numberStr) {
        try {
            long number = Long.parseLong(numberStr);
            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage() + ": " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            if (numberStr.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.MISSING_NUMBERS.getMessage());
            }
            if (isTooLarge(numberStr)) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_TOO_LARGE.getMessage() + ": " + numberStr);
            }
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage() + ": " + numberStr);
        }
    }

    private boolean isTooLarge(String numberStr) {
        try {
            new BigInteger(numberStr);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}

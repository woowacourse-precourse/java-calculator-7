package calculator.validator;

import calculator.exception.ErrorMessage;
import calculator.util.IntegerUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimiterNumberValidator {

    private static final int MINIMUM_ALLOWED_NUMBER = 0;

    public List<Integer> isValidNumber(String[] number) {
        return Arrays.stream(number)
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    private int parseNumber(String number) {
        if (IntegerUtils.isNumeric(number)) {
            int parseInt = Integer.parseInt(number);
            validatePositiveNumber(parseInt);
            return parseInt;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
    }

    private void validatePositiveNumber(int parseInt) {
        if (parseInt < MINIMUM_ALLOWED_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

}
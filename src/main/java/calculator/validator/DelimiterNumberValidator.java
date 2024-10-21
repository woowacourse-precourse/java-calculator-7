package calculator.validator;

import calculator.exception.ErrorMessage;
import calculator.util.IntegerUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimiterNumberValidator {

    private static final int MINIMUM_ALLOWED_NUMBER = 0;

    public List<Integer> isValidNumber(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::parseAndValidateNumber)
                .collect(Collectors.toList());
    }

    private int parseAndValidateNumber(String number) {
        int parsedNumber = parseNumber(number);
        validatePositiveNumber(parsedNumber);
        return parsedNumber;
    }

    private int parseNumber(String number) {
        if (IntegerUtils.isNumeric(number)) {  // 숫자인지 확인 후 변환
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
    }

    private void validatePositiveNumber(int number) {
        if (number < MINIMUM_ALLOWED_NUMBER) {  // 음수인지 검증
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

}
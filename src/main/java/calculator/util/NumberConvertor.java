package calculator.util;

import calculator.domain.Delimiter;
import calculator.validator.DelimiterValidator;
import calculator.validator.NumberValidator;
import calculator.global.exception.ErrorMessage;

import java.util.Arrays;


public class NumberConvertor {

    public static int[] stringToInt(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return new int[] {};
        }

        return Arrays.stream(getRemovedEnrollmentChar(str).split(Delimiter.getDelimiter()))
                .mapToInt(NumberConvertor::parseAndValidate)
                .toArray();
    }

    private static String getRemovedEnrollmentChar(String str) {
        return Delimiter.removeEnrollmentString(str);
    }

    private static int parseAndValidate(String str) {
        DelimiterValidator.validateIncludeDelimiter(str);
        try {
            int number = Integer.parseInt(str);
            NumberValidator.validatePositiveNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_STRING_FORMAT_ERROR.getMessage());
        }
    }
}
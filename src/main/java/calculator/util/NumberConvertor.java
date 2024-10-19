package calculator.util;

import calculator.domain.Delimiter;
import calculator.validator.DelimiterValidator;
import calculator.validator.NumberValidator;

import java.util.Arrays;

public class NumberConvertor {

    public static int[] stringToInt(String str) {
        String removedEnrollmentChar = Delimiter.removeEnrollmentString(str);

        if (str.isEmpty()) {
            return new int[] {};
        }

        String delimiter = Delimiter.getDelimiter();

        return Arrays.stream(removedEnrollmentChar.split(delimiter))
                .mapToInt(NumberConvertor::parseAndValidate)
                .toArray();
    }

    private static int parseAndValidate(String str) {
        DelimiterValidator.validateIncludeDelimiter(str);
        int number = Integer.parseInt(str.trim());
        NumberValidator.validatePositiveNumber(number);
        return number;
    }
}
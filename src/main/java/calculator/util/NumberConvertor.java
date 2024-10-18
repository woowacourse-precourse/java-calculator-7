package calculator.util;

import calculator.domain.Delimiter;
import calculator.validator.NumberValidator;

import java.util.Arrays;

public class NumberConvertor {

    public static int[] stringToInt(String str) {
        String removedEnrollmentChar = Delimiter.removeEnrollmentChar(str);

        if (str.isEmpty()) {
            return new int[] {};
        }

        return Arrays.stream(removedEnrollmentChar.split(Delimiter.getDelimiter()))
                .mapToInt(NumberConvertor::parseAndValidate)
                .toArray();
    }

    private static int parseAndValidate(String s) {
        int number = Integer.parseInt(s.trim());
        NumberValidator.validatePositiveNumber(number);
        return number;
    }
}
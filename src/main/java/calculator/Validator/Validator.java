package calculator.Validator;

import calculator.exception.Exceptions;
import java.util.Arrays;

public class Validator {

    public static void validate(String[] values) {
        Arrays.stream(values)
                .forEach(v -> {
                    validateNumberFormat(v);
                    validateMinus(v);
                });
    }

    private static void validateNumberFormat(String v) {
        try {
            Double.parseDouble(v);
        } catch (NumberFormatException e) {
            throw Exceptions.onlyNumberInput();
        }
    }

    private static void validateMinus(String v) {
        if (Double.parseDouble(v) < 0) {
            throw Exceptions.onlyPlusNumber();
        }
    }
}

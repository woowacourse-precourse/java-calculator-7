package calculator;

import java.util.List;

public abstract class Validator {

    public static void validateIfInputNegative(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validate(String splitInput) {
        try {
            Integer.parseInt(splitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

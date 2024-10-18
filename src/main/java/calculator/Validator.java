package calculator;

import java.util.List;
import java.util.Set;

public class Validator {
    private static final List<String> FIXED_DELIMITERS = List.of(",", ":");

    public void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!input.startsWith("//") && (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1)))) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDelimeters(Set<String> delimiters) {
        if (delimiters.size() > 1 && !delimiters.containsAll(FIXED_DELIMITERS)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}

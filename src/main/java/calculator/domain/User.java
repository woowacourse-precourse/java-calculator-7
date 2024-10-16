package calculator.domain;


import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<String> numbers = new ArrayList<>();
    private final List<String> delimiters = new ArrayList<>();

    public User(String userString) {
        charAtUserStrings(userString);
        validateNumbers(numbers);
        validateDelimiters(delimiters);
    }

    private void charAtUserStrings(String userString) {
        for (int i = 0; i < userString.length(); i++) {
            char charAt = userString.charAt(i);
            if (Character.isDigit(charAt)) {
                numbers.add(String.valueOf(charAt));
            } else {
                delimiters.add(String.valueOf(charAt));
            }
        }
    }

    private void validateNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (Integer.parseInt(number) <= 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDelimiters(List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (!delimiter.equals(",") && !delimiter.equals(":")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
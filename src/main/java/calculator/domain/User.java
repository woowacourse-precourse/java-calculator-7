package calculator.domain;


import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String NEW_DELIMITER_PATTERN = "//\\n";
    private static final int START_INDEX = 0;
    private static final int MIN_NUMBER_SIZE = 0;

    private final List<String> numbers = new ArrayList<>();
    private final List<String> delimiters = new ArrayList<>();


    public User(String userString) {
        charAtUserStrings(userString);
        validateNumbers(numbers);
        checkDelimiters(delimiters);
    }

    private void checkDelimiters(List<String> delimiters) {
        if (delimiters.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (delimiters.contains("/")) {
            validateNewDelimiters(delimiters);
        } else {
            validateDelimiters(delimiters);
        }
    }

    private void validateDelimiters(List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (!delimiter.equals(",") && !delimiter.equals(":")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNewDelimiters(List<String> delimiters) {
        String str = delimiters.get(0) + delimiters.get(1) + delimiters.get(3) + delimiters.get(4);
        if (str.equals(NEW_DELIMITER_PATTERN)) {
            delimiters.removeFirst();
            delimiters.removeFirst();
            delimiters.removeFirst();
            delimiters.removeFirst();
            delimiters.removeFirst();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void charAtUserStrings(String userString) {
        for (int i = START_INDEX; i < userString.length(); i++) {
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
            if (Integer.parseInt(number) <= MIN_NUMBER_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
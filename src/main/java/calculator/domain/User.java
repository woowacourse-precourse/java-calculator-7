package calculator.domain;


import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String NEW_DELIMITER_PATTERN = "//\\n";
    private static final int START_INDEX = 0;
    private static final int MIN_NUMBER_SIZE = 0;

    private final List<String> numbers = new ArrayList<>();
    private final List<String> delimiters = new ArrayList<>();


    public static User userString(String userString) {
        return new User(userString);
    }

    private User(String userString) {
        charAtUserStrings(userString);
        validateNumbers(numbers);
        checkDelimiters(delimiters);
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

    private void checkDelimiters(List<String> delimiters) {
        if (delimiters.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (delimiters.contains("/")) {
            String newDelimiter = validateNewDelimiters(delimiters);
            validateDelimiters(delimiters, newDelimiter);
        } else {
            validateDelimiters(delimiters);
        }
    }

    private String validateNewDelimiters(List<String> delimiters) {
        String str = delimiters.get(0) + delimiters.get(1) + delimiters.get(3) + delimiters.get(4);
        if (str.equals(NEW_DELIMITER_PATTERN)) {
            String newDelimiter = delimiters.get(2);
            delimiters.removeFirst();
            delimiters.removeFirst();
            delimiters.removeFirst();
            delimiters.removeFirst();
            delimiters.removeFirst();
            return newDelimiter;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void validateDelimiters(List<String> delimiters, String newDelimiter) {
        for (String delimiter : delimiters) {
            if (!delimiter.equals(",") && !delimiter.equals(":") && !delimiter.equals(newDelimiter)) {
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

    public List<String> getNumbers() {
        return numbers;
    }
}
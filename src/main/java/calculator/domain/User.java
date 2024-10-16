package calculator.domain;


import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<String> numbers = new ArrayList<>();
    private final List<String> delimiters = new ArrayList<>();


    public User(String userString) {
        charAtUserStrings(userString);
        validateNumbers(numbers);
        if (delimiters.get(0).equals('/')) {
            String newDelimiters = validateNewDelimiters(delimiters);
            validateDelimiters(delimiters, newDelimiters);
        }
        validateDelimiters(delimiters);
    }

    private void validateDelimiters(List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (!delimiter.equals(",") && !delimiter.equals(":")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String validateNewDelimiters(List<String> delimiters) {
        String str = delimiters.get(0) + delimiters.get(1) + delimiters.get(3) + delimiters.get(4);
        if (str.equals("//\\n")) {
            return delimiters.get(2);
        } else {
            throw new IllegalArgumentException();
        }
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

    private void validateDelimiters(List<String> delimiters, String newDelimiters) {
        for (String delimiter : delimiters) {
            if (!delimiter.equals(",") && !delimiter.equals(":") && !delimiter.equals(newDelimiters)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
package calculator.domain;


import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<String> numbers = new ArrayList<>();
    private final List<String> delimiters = new ArrayList<>();

    public User(String userString) {
        charAtUserStrings(userString);
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
}
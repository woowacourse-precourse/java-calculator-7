package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private static final String BASE_DELIMITER = ",:";
    private static final String NUMBERS = "1234567890";
    private final List<Character> delimiters = new ArrayList<>();

    public Delimiter() {
        for (int i = 0; i < BASE_DELIMITER.length(); i++) {
            delimiters.add((BASE_DELIMITER.charAt(i)));
        }
    }

    public void addCustomDelimiter(String customDelimiter) {
        for (int i = 0; i < customDelimiter.length(); i++) {
            char target = customDelimiter.charAt(i);
            if (NUMBERS.indexOf(target) != -1) {
                throw new IllegalArgumentException();
            }
            delimiters.add((target));
        }
    }

    public boolean isContain(char delimiter) {
        return delimiters.contains(delimiter);
    }
}

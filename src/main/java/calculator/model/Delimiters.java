package calculator.model;

import java.util.ArrayList;

public class Delimiters {
    private final ArrayList<Character> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(';');
    }

    public void addCustomDelimiter(char customDelimiter) {
        if (isCustomDelimiterDigit(customDelimiter)) {
            throw new IllegalArgumentException();
        }
        delimiters.add(customDelimiter);
    }

    public boolean isCustomDelimiterDigit(char customDelimiter) {
        return Character.isDigit(customDelimiter);
    }
}

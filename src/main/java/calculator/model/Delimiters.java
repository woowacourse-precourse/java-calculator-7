package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Delimiters {
    private final ArrayList<Character> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(':');
    }

    public List<Character> getDelimiters() {
        return Collections.unmodifiableList(delimiters);
    }

    public void addCustomDelimiter(char customDelimiter) {
        if (isCustomDelimiterDigit(customDelimiter)) {
            throw new IllegalArgumentException();
        }
        delimiters.add(customDelimiter);
    }

    private boolean isCustomDelimiterDigit(char customDelimiter) {
        return Character.isDigit(customDelimiter);
    }
}

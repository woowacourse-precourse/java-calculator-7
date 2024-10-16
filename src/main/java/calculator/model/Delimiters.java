package calculator.model;

import java.util.ArrayList;

public class Delimiters {
    private final ArrayList<Character> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(';');
    }

    public boolean usesCustomDelimiter(String inputString) {
        char firstChar = inputString.charAt(0);
        return firstChar == '/';
    }
}

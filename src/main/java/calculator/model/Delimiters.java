package calculator.model;

import java.util.ArrayList;

public class Delimiters {
    private final ArrayList<Character> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(';');
    }

    public void correctCustomDelimiterOrThrow(String inputString) {
        if (usesCustomDelimiter(inputString)) {
            return;
        }
        if (!isCustomDelimiterFirstFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
        if (!isCustomDelimiterLastFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
        if (!isCustomDelimiterNotDigit(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean usesCustomDelimiter(String inputString) {
        char firstChar = inputString.charAt(0);
        return firstChar == '/';
    }

    public boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals("//");
    }

    public boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals("\n");
    }

    public boolean isCustomDelimiterNotDigit(String inputString) {
        char customDelimiter = inputString.charAt(2);
        return Character.isDigit(customDelimiter);
    }
}

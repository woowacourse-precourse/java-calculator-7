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

    public boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals("//");
    }

    public boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals("\n");
    }
}

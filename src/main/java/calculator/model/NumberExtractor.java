package calculator.model;

public class NumberExtractor {
    private boolean isStartingWithDigit(String inputString) {
        char firstChar = inputString.charAt(0);
        return Character.isDigit(firstChar);
    }
}

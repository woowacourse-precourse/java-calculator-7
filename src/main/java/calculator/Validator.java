package calculator;

public class Validator {
    public boolean hasCustomSeparator(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    public boolean isStartWithDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }
}

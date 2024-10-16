package calculator;

public class Validator {
    public boolean hasCustomSeparator(String input) {
        return input.startsWith("//") && input.contains("\n");
    }
}

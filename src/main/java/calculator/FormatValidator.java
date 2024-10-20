package calculator;

public class FormatValidator {
    public static void validateInput(String input, String delimiter) {
        input = input.replaceAll("[0-9]", "").replaceAll(delimiter, "");
        if (!input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}

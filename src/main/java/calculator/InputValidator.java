package calculator;

public class InputValidator {

    public static String handleBlankInput(String input) {
        if (input.isBlank()) {
            return "0";
        }
        return input;
    }
}

package calculator.domain;

public class InputValidator {

    public static boolean isExistCustomSeparator(String input) {
        if (input.contains("//") && input.contains("\\n")) {
            return true;
        }
        return false;
    }
}

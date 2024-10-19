package calculator;

public class InputValidator {

    public boolean isEmptyInput(String input) {
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }
}
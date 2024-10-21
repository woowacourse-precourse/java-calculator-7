package calculator.domain.validator;

public class InputValidator {

    private static final String REGEX_NUMERIC = "\\d+";

    public boolean isNegativeNumber(String input) {
        return input.contains("-");
    }

    public boolean checkInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public boolean isValidNumber(String str) {
        return str.matches(REGEX_NUMERIC);
    }

}

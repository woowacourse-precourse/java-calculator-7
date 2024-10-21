package calculator.domain.validator;

public class InputValidator {

    private static final String REGEX_NUMERIC = "\\d+";

    public boolean isNonPositiveNumber(String input) {
        input = input.trim().replaceFirst("^0+(?!$)", "");

        return input.startsWith("-") || input.equals("0");
    }

    public boolean checkInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public boolean isValidNumber(String str) {
        return str.matches(REGEX_NUMERIC);
    }

}

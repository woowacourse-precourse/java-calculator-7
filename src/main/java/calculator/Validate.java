package calculator;

public class Validate {
    static String INCORRECT_CHARACTER = "\\D+";
    static String MESSAGE = "incorrect input: ";

    static void validate(String[] splitInput) throws IllegalArgumentException {
        for (String input: splitInput) {
            if (input.matches(INCORRECT_CHARACTER)) {
                throw new IllegalArgumentException(MESSAGE + input);
            }
            if (input.equals("")) {
                throw new IllegalArgumentException(MESSAGE + input);
            }
            if (Long.parseLong(input) <= 0) {
                throw new IllegalArgumentException(MESSAGE + input);
            }
        }
    }
}

package calculator;

public class Validate {
    static String INCORRECT_CHARACTER = ".*[a-zA-Z]+.*";
    static String MESSAGE = "incorrect input: ";

    static void validate(String[] splitInput) throws IllegalArgumentException {
        for (String input: splitInput) {
            if (input.matches(INCORRECT_CHARACTER)) {
                throw new IllegalArgumentException(MESSAGE + input);
            }
        }
    }
}

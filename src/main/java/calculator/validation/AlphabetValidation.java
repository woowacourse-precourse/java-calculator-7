package calculator.validation;

public class AlphabetValidation {
    public static void alphabet(String input) {
        if (isAlphabet(input)) {
            throw new IllegalArgumentException("양수만 입력가능합니다.");
        }
    }

    public static boolean isAlphabet(String input) {
        return input.matches("[a-zA-Z]");
    }
}

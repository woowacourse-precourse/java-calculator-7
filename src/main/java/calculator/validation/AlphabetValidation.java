package calculator.validation;

import java.util.Arrays;

public class AlphabetValidation {

    public static void alphabet(String input) {
        if (isAlphabet(input)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private static boolean isAlphabet(String input) {
        return input.matches("[a-zA-Z]");
    }
}

package calculator.validation;

import java.util.Arrays;

public class AlphabetValidation {

    public static void alphabet(String input) {
        if (validation(input)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private static boolean validation(String input) {
        String replaceInput = input;
        if (input.contains("\\n")) {
            replaceInput = input.replace("\\n", "");
        }
        String[] inputStrings = replaceInput.split("");
        System.out.println(Arrays.toString(inputStrings));
        for (String inputString : inputStrings) {
            if (isAlphabet(inputString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAlphabet(String input) {
        return input.matches("[a-zA-Z]");
    }
}

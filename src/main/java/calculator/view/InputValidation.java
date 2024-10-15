package calculator.view;

public class InputValidation {

    public static String readStringValidation(String input) {
        String[] inputStrings = input.split("");
        for (String inputString : inputStrings) {
            if (isAlphabet(inputString)) {
                throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다.");
            }
        }
        return input;
    }

    private static boolean isAlphabet(String input) {
        return input.matches("[a-zA-Z]");
    }
}

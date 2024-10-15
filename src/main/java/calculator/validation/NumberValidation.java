package calculator.validation;

public class NumberValidation {

    public static void number(String input) {
        String[] inputStrings = input.split("");
        for (String inputString : inputStrings) {
            if (isNotPositiveNumber(inputString)) {
                throw new IllegalArgumentException("양수만 입력가능합니다.");
            }
        }
    }

    private static boolean isNotPositiveNumber(String input) {
        return input.equals("0") || input.contains("-");
    }
}

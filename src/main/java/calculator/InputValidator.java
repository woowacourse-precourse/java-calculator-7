package calculator;

public class InputValidator {

    public static void validate(String numbersSection, String delimiters) {
        if (!isValidInput(numbersSection, delimiters)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    private static boolean isValidInput(String numbersSection, String delimiters) {
        if (numbersSection.isBlank()) {
            return true;
        }

        String regex = "^\\d+(" + "[" + delimiters + "]" + "\\d+)*$";
        return numbersSection.matches(regex);
    }
}

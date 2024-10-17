package calculator;

public class Validator {

    public static String validateInput(String input) {
        if (input.isBlank()) {
            input = "0";
        }

        return input.trim();
    }

    public static String validateConvertedInput(String input, String delimiterRegex) {
        if (input.isBlank()) {
            input = "0";
        }
        if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("문자열의 시작과 끝에는 숫자가 와야 합니다.");
        }
        String continuousRegex = ".*(" + delimiterRegex + "){2,}.*";
        if (input.matches(continuousRegex)) {
            throw new IllegalArgumentException("구분자는 연속해서 올 수 없습니다.");
        }

        return input;
    }
}

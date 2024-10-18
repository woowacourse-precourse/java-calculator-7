package calculator;

import java.util.Arrays;

public class Validator {

    public static String validateInput(String input) {
        if (input.isBlank()) {
            input = "0";
        }

        return input.trim();
    }

    public static String validateConvertedInput(String input, String delimiterRegex, String[] strNumArray) {
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

        boolean splitIsNotValid = Arrays.stream(strNumArray)
                .anyMatch(s -> !s.matches("\\d+"));
        if (splitIsNotValid) {
            throw new IllegalArgumentException("숫자 추출에서 유효하지 않은 값이 검출되었습니다.");
        }

        return input;
    }
}

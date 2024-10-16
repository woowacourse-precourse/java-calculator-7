package calculator.util;

public class Validator {

    public static boolean isValidate(String input) {

        // 문자열이 빈 경우
        // empty 인 경우 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if (input == null) {
            throw new IllegalArgumentException("Input Invalid case1 : input is null");
            // unchecked exception
        }

        // 문자열에 숫자가 없는 경우
        if (!input.matches("(?s).*\\d.*")) {
            throw new IllegalArgumentException("Input Invalid case2");
        }


        return true;
    }
}

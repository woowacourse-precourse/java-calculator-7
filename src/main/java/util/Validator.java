package util;

public class Validator {

    public static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
        }
    }
}

package calculator;

public class InputValidator {
    public static String validateToken(String token) {
        if (!token.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("문자열에 구분자, 양수 외 문자가 포함되어 있습니다.");
        }
        return token;
    }
}

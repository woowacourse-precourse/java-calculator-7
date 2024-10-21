package calculator;

public class NumberValidator {

    // 입력된 문자열을 검증하고 정수로 변환
    public static int validateAndParse(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

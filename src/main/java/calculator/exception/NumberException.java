package calculator.exception;

public class NumberException {
    private static final int POSITIVE_NUMBER = 1;

    public static int parseAndValidateInt(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < POSITIVE_NUMBER) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자 이외에 숫자만 입력가능합니다.");
        }
    }
}

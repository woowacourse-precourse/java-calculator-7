package calculator;

public class InputValidator {
    public static void validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
        }
    }

    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }
}

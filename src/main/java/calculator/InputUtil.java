package calculator;

public class InputUtil {

    public static void checkDigit(String input) {
        int tmp = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                tmp = 1;
            }
        }
        if (tmp == 0) {
            throw new IllegalArgumentException("숫자가 존재하지 않습니다.");
        }
    }

    public static void checkPositiveNumber(String[] array) {
        for (String s : array) {
            if (Integer.parseInt(s) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}

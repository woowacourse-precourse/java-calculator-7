package calculator.util;

public class InputUtil {

    public static void checkInputDigit(String input) {
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

    public static void checkArrayNumber(String[] array) {
        for (String s : array) {
            checkArrayDigit(s);
            if (Integer.parseInt(s) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }

    public static void checkArrayDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
        }
    }

}

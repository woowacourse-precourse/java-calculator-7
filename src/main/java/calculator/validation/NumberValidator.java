package calculator.validation;

public class NumberValidator {

    public static void isNotNumber(String number) {
        if (number.isEmpty() || !isInteger(number)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

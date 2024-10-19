package calculator.validation;

public class NumberValidator {

    public static void isNotNumberOrNotPositive(String number) {
        if (number.isEmpty() || !isInteger(number) || !isPositive(number)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositive(String number) {
        if (Integer.parseInt(number) > 0) {
            return true;
        }
        return false;
    }
}

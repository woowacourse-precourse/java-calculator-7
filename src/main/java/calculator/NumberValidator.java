package calculator;

public abstract class NumberValidator {
    public static int validate(String str) {
        if (!isNumeric(str)) {
            throw new IllegalArgumentException("잘못된 입력입니다: " + str);
        }
        return validateIfNegative(str);
    }

    private static int validateIfNegative(String str) {
        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return number;
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

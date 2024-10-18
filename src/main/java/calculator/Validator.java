package calculator;

public class Validator {
    public static long validate(final String str) {
        if (str.isEmpty()) return 0;

        if (isNotDigit(str))
            throw new IllegalArgumentException("[ERROR] 지정되지 않은 구분자입니다.");

        long num = Long.parseLong(str);
        if (isNegative(num))
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");

        return num;
    }

    private static boolean isNotDigit(final String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return true;
        }
        return false;
    }

    private static boolean isNegative(long num) {
        return num < 0;
    }
}

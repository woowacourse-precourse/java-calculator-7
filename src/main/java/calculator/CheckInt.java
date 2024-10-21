package calculator;

public class CheckInt {
    public static int toPositiveInt(String str) {

        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        return num;
    }
}

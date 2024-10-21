package calculator.common;

public class ValidationUtil {

    public static void validateNumbers(String[] tokens) {
        try {
            for (String token : tokens) {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수 입력값은 허용되지 않습니다.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값이 포함되어 있습니다.");
        }
    }
}

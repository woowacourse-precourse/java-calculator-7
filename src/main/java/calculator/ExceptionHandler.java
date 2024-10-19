package calculator;

public class ExceptionHandler {
    public static void handleInvalidDelmiter(String delmiter) {
        if (delmiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
    }

    public static void handleInvalidNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}

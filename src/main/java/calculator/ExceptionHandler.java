package calculator;

public class ExceptionHandler {
    public static void handleInvalidDelmiter(String delmiter) {
        if (delmiter.isEmpty()) {
            throw createIllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
    }

    public static void handleNonNumbericInput(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw createIllegalArgumentException("구분자로 등록되지 않은 문자를 사용하였습니다: " + c);
            }
        }
    }

    private static IllegalArgumentException createIllegalArgumentException(String message) {
        return new IllegalArgumentException(message);
    }
}

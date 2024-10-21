package calculator;

// 예외처리를 담당하는 클래스
public class ExceptionHandler {
    // 커스텀 구분자가 비어있을 때 예외처리 <- //\n로 입력되었을 경우
    public static void handleInvalidDelmiter(String delmiter) {
        if (delmiter.isEmpty()) {
            throw createIllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
    }

    // 기본, 커스텀 구분자로 등록되지 않은 구분자를 사용할 경우 예외처리
    public static void handleNonNumbericInput(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw createIllegalArgumentException("구분자로 등록되지 않은 문자를 사용하였습니다: " + c);
            }
        }
    }

    // 입력된 숫자가 int의 범위를 넘어설 경우 예외처리
    public static void handleNumberRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw createIllegalArgumentException(Integer.MAX_VALUE + " 이상의 숫자는 계산할 수 없습니다.");
        }
    }

    private static IllegalArgumentException createIllegalArgumentException(String message) {
        return new IllegalArgumentException(message);
    }
}

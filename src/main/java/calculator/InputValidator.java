package calculator;

public class InputValidator {
    public static void validate(String input) {
        // 빈 문자열 처리
        if (validateEmpty(input)) {
            return;
        }
        ;

        // 커스텀 구분자로 시작할 경우 바로 리턴
        // 이후 커스
        if (validateStartsWithDelimiter(input)) {
            return;
        }

        validateStartsWithPositiveNumber(input);

        validateNotStartsWithChar(input);

        validateNotStartsWithNegativeNumber(input);
    }

    private static void validateNotStartsWithNegativeNumber(String input) {
        if (input.startsWith("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    private static void validateNotStartsWithChar(String input) {
        if (!isStartsWithDigit(input)) {
            throw new IllegalArgumentException("커스텀 문자 지정 외에는 문자로 시작할 수 없습니다.");
        }
    }

    private static void validateStartsWithPositiveNumber(String input) {
        if (isStartsWithDigit(input)) return;
    }

    private static boolean isStartsWithDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    private static boolean validateStartsWithDelimiter(String input) {
        return input.startsWith("//");
    }

    private static boolean validateEmpty(String input) {
        // 빈 문자열일 경우 정상 동작
        if (input.isEmpty()) return true;
        return false;
    }
}

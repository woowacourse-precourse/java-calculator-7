package calculator;

public class InputValidator {
    public static String validate(String input) {

        // 커스텀 구분자로 시작할 경우 커스텀 구분자 관련 호출 진행 (추출후 이후 문자열 검사.)
        String result = "";
        if (validateStartsWithDelimiter(input)) {
            result = CustomDelimiter.extractCustomDelimiter(input);
            // customDelimiter를 직접 호출하는 대신, Getter 메서드 사용
            return Parser.startsWithCustomDelimiter(CustomDelimiter.getCustomDelimiter(), result);
        }

        // 빈 문자열 처리
        if (validateEmpty(input)) {
            return result = "0";
        }

        validateNotStartsWithChar(input);
        validateNotStartsWithNegativeNumber(input);

        // 여기까지 왔으면 숫자로 시작, 기본 구분자로 파싱하는 단계로 이동
        return Parser.startsWithPositiveNumber(input);
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

    private static boolean isStartsWithDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    protected static boolean validateStartsWithDelimiter(String input) {
        return input.startsWith("//");
    }

    private static boolean validateEmpty(String input) {
        return input.isEmpty();
    }
}

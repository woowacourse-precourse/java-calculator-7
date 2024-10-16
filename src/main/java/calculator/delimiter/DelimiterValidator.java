package calculator.delimiter;

public class DelimiterValidator {
    public static void validateInputLength(String input) {
        if (input.length() < 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void validateCustomDelHeader(String customDelHeader) {
        if (!customDelHeader.endsWith("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 설정은 \\n 으로 끝나야합니다.");
        }
    }

    public static void validateCustomDel(char customDel, String defaultDel) {
        if (defaultDel.contains(String.valueOf(customDel))) {
            throw new IllegalArgumentException("기본 구분자와 중복되는 커스텀 구분자입니다.");
        }
    }
}

package calculator.delimiter;

public class DelimiterValidator {
    private static final String SPECIAL_CHARACTERS = "[]";

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
        if (isDefaultDel(customDel, defaultDel)) {
            throw new IllegalArgumentException("기본 구분자와 중복되는 커스텀 구분자입니다.");
        }
    }

    private static boolean isDefaultDel(char customDel, String defaultDel) {
        return defaultDel.contains(String.valueOf(customDel));
    }

    public static String escapeSpecialCharacters(char customDel) {
        return isSpecialChar(customDel) ? "\\" + customDel : String.valueOf(customDel);
    }

    private static boolean isSpecialChar(char customDel) {
        return SPECIAL_CHARACTERS.contains(String.valueOf(customDel));
    }
}

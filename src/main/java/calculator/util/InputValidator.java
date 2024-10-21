package calculator.util;

public class InputValidator {
    public static void validate(String input) {
        hasWhiteSpace(input);
        validStartWord(input);
        validEndWord(input);
        validDelimiters(input);
    }

    private static void hasWhiteSpace(String input) {
        if (input.contains(" ")) {
           throw new IllegalArgumentException("입력 문자열은 공백을 포함할 수 없습니다.");
        }
    }

    private static void validStartWord(String input) {
        if (input.startsWith(",") || input.startsWith(":")) {
           throw new IllegalArgumentException("입력 문자열은 구분자로 시작할 수 없습니다.");
        }
    }

    private static void validEndWord(String input) {
        if (input.endsWith(",") || input.endsWith(":")) {
           throw new IllegalArgumentException("입력 문자열은 구분자로 끝날 수 없습니다.");
        }
    }

    private static void validDelimiters(String input) {
        String defaultDelimiter = "^(\\d+([,:]\\d+)*)$";
        String customDelimiter = "//(.*)\\\\n(.*)";

        System.out.println(input.matches(defaultDelimiter));

        if (!input.matches(defaultDelimiter) && !input.matches(customDelimiter)) {
            throw new IllegalArgumentException("입력 문자열이 유효한 구분자를 포함하지 않습니다.");
        }
    }
}

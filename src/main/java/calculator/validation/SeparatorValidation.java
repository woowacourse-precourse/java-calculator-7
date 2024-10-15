package calculator.validation;

public class SeparatorValidation {

    public static void separator(String input) {
        if (isNotSeparator(input)) {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
        }
    }

    private static boolean isNotSeparator(String input) {
        return !input.contains(":") && !input.contains(",") && (!input.contains("//") || !input.contains("\\n"));
    }
}

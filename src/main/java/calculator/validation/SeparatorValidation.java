package calculator.validation;

public class SeparatorValidation {

    public static void separator(String input) {
        if (isNotSeparator(input)) {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
        }
    }

    private static boolean isNotSeparator(String input) {
        if (!input.contains(",") && !input.contains(":")) {
            if (containCustomSeparator(input) || notContainSpecialCharacters(input)) {
                return false;
            }
            return true;
        }
        if (!input.contains(",") || !input.contains(":")) {
            if (notContainSpecialCharacters(input)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean containCustomSeparator(String input) {
        return input.contains("//") && input.contains("\\n");
    }

    private static boolean notContainSpecialCharacters(String input) {
        return !input.matches(".*[^a-zA-Z0-9가-힣,: ].*");
    }
}

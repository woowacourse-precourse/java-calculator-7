package calculator.validation;

public class SeparatorValidation {

    public static void separator(String input) {
        if (isNotSeparator(input)) {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
        }
        if (containCustomSeparator(input)) {
            if (input.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자는 반드시 앞에 있어야합니다.");
            }
            if (test(input)) {
                throw new IllegalArgumentException("잘못된 구분자입니다.");
            }
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
        return !input.matches(".*[^a-zA-Z0-9가-힣,:\\- ].*");
    }

    private static boolean test(String input) {
        StringBuilder customPatten = new StringBuilder();
        String customSeparator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        String[] customSeparators = customSeparator.split("");
        for (String separator : customSeparators) {
            customPatten.append("\\").append(separator);
        }
        String patten = "[^\\w가-힣,:\\-" + customPatten + " ]";
        input = input.substring(input.indexOf("\\n") + 2);
        String[] inputStrings = input.split("");
        for (String inputString : inputStrings) {
            if (inputString.matches(patten)) {
                return true;
            }
        }
        return false;
    }
}

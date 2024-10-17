package calculator.validation;

import calculator.number.CustomPatternMaker;

public class SeparatorValidation {

    public static void separator(String input) {
        if (isNotSeparator(input)) {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
        }
        // 커스텀 구분자를 사용할 경우 검사
        if (input.contains("//") || input.contains("\\n")) {
            if (!containCustomSeparator(input)) {
                throw new IllegalArgumentException("커스텀 구분자를 사용하려면 반드시 //과 \\n 모두 사용해야 합니다.");
            }
            if (input.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자는 반드시 앞에 있어야합니다.");
            }
            if (isNotCustomPattern(input)) {
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
        return !input.matches("[^\\w가-힣,:\\-]");
    }

    private static boolean isNotCustomPattern(String input) {
        String customPattern = CustomPatternMaker.getCustomPattern(input);
        customPattern = customPattern.replaceAll("\\|", "");
        String pattern = "[^\\wㄱ-ㅎ가-힣,:\\-" + customPattern + " ]";
        input = input.substring(input.indexOf("\\n") + 2);
        String[] inputStrings = input.split("");
        for (String inputString : inputStrings) {
            if (inputString.matches(pattern)) {
                return true;
            }
        }
        return false;
    }
}

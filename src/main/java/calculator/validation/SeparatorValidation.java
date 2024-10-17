package calculator.validation;

import calculator.number.CustomPatternMaker;

public class SeparatorValidation {

    private static final String NOT_SPECIAL_CHARACTERS = "^\\wㄱ-ㅎ가-힣,:\\-";

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
        return !input.matches("[" + NOT_SPECIAL_CHARACTERS + " ]+");
    }

    private static boolean isNotCustomPattern(String input) {
        String customPattern = CustomPatternMaker.getCustomPattern(input);
        // 커스텀 구분자는 뒤에 | 이 붙으므로 제거해준다.
        customPattern = customPattern.replaceAll("\\|", "");
        // 커스텀 구분자와 특수문자 아닌 문자들을 정규표현식으로 묶어준다.
        String pattern = "[" + NOT_SPECIAL_CHARACTERS + customPattern + " ]+";
        // 커스텀 구분자를 제외 시켜준다.
        input = input.substring(input.indexOf("\\n") + 2);
        // 문자열 안에 커스텀 구분자와 기본 구분자 외의 특수문자가 있는지 검사한다.
        String[] inputStrings = input.split("");
        for (String inputString : inputStrings) {
            if (inputString.matches(pattern)) {
                return true;
            }
        }
        return false;
    }
}

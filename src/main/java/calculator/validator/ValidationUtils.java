package calculator.validator;

import java.util.regex.Matcher;

public class ValidationUtils {
    public static void validateStartWithDoubleSlash(String inputString) {
        if (!inputString.startsWith("//") && !Character.isDigit(inputString.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: " + inputString);
        }
    }

    public static void validateCustomLineFormat(Matcher delimiterStringMatcher) {
        if (!delimiterStringMatcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 입력 형식이 잘못되었습니다.");
        }
        validateDuplicatedCharacter(delimiterStringMatcher.group(1));
        validateIllegalNumericDelimiter(delimiterStringMatcher.group(1));
    }

    private static void validateDuplicatedCharacter(String delimiterString) {
        StringBuilder checkedDelimiter = new StringBuilder();
        for (char delimiter : delimiterString.toCharArray()) {
            if (!checkedDelimiter.toString().contains(String.valueOf(delimiter))) {
                checkedDelimiter.append(delimiter);
                continue;
            }
            throw new IllegalArgumentException("중복된 커스텀 구분자가 입력되었습니다.");
        }
    }

    private static void validateIllegalNumericDelimiter(String delimiterString) {
        for (char delimiter : delimiterString.toCharArray()) {
            if (Character.isDigit(delimiter)) {
                throw new IllegalArgumentException("숫자는 입력되지 않습니다.");
            }
        }
    }

    public static void validateNumberLineExist(Matcher numberLineMatcher) {
        if (!numberLineMatcher.find()) {
            throw new IllegalArgumentException("숫자 라인이 입력되지 않았습니다.");
        }
    }
}

package validator;

import utils.Utils;

public class Validator {

    private static final int NOT_ALLOWED_ZERO = 0;
    private static final String NON_DIGIT_PATTERN = ".*[^0-9].*";

    // 쉼표, 콜론, 커스텀 구분자, 숫자 이외의 문자를 입력한 경우 예외 발생
    public static void validateAllowedCharacters(String userInput, String customDelimiter) {
        if (userInput.isEmpty()) {
            return;
        }

        String removedCommas = Utils.removeCommas(userInput);
        String removedColons = Utils.removeColons(removedCommas);
        String removedDelimiter = Utils.removeDelimiters(removedColons, customDelimiter);

        boolean hasNonDigits = removedDelimiter.matches(NON_DIGIT_PATTERN);

        if (hasNonDigits) {
            throw new IllegalArgumentException("허용되지 않은 문자가 포함되어 있습니다. (쉼표, 콜론, 커스텀 구분자만 허용)");
        }
    }

    // 숫자 0을 입력한 경우 예외 발생
    public static void validateIncludeZero(int number) {
        if (number == NOT_ALLOWED_ZERO) {
            throw new IllegalArgumentException("숫자 0은 입력할 수 없습니다. (양수만 허용)");
        }
    }

    // "//"과 "\n" 중 하나만 사용한 경우 예외 발생
    public static void validateDelimiterDeclaration(String userInput, String declarationPrefix,
                                                    String declarationSuffix) {
        if (userInput.startsWith(declarationPrefix) && !userInput.contains(declarationSuffix)) {
            throw new IllegalArgumentException("커스텀 구분자를 사용할 경우 반드시 '//'와 '\\n'을 함께 사용해야 합니다.");
        }
        if (userInput.contains(declarationSuffix) && !userInput.startsWith(declarationPrefix)) {
            throw new IllegalArgumentException("커스텀 구분자를 사용할 경우 반드시 '//'와 '\\n'을 함께 사용해야 합니다.");
        }
    }
}

package validator;

import utils.Utils;

public class Validator {

    private static final int ZERO_NOT_ALLOWED = 0;
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
        if (number == ZERO_NOT_ALLOWED) {
            throw new IllegalArgumentException("숫자 0은 입력할 수 없습니다. (양수만 허용)");
        }
    }

    // 올바르지 않은 커스텀 구분자 선언을 한 경우 예외 발생
    public static void validateDelimiterDeclaration(String userInput, String declarationPrefix,
                                                    String declarationSuffix) {
        // ["//"만 입력된 경우] 예외 발생
        if (userInput.startsWith(declarationPrefix) && !userInput.contains(declarationSuffix)) {
            throw new IllegalArgumentException("유효한 커스텀 구분자 선언 형식으로 입력해주세요. : //{커스텀 구분자}\\n{문자열}");
        }

        // ["\n"만 입력된 경우] 또는 [선언 순서가 뒤바뀐 경우] 또는 [선언이 문자열 앞부분이 아닌 경우] 예외 발생
        if (userInput.contains(declarationSuffix) && !userInput.startsWith(declarationPrefix)) {
            throw new IllegalArgumentException("유효한 커스텀 구분자 선언 형식으로 입력해주세요. : //{커스텀 구분자}\\n{문자열}");
        }
    }
}

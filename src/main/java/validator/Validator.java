package validator;

import utils.Utils;

public class Validator {

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
}
